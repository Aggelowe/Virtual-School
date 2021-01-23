package eu.margaritis.aggelos.projects.virtualschool.events;

import java.util.List;

import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.player.PlayerInteractEvent.RightClickBlock;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import eu.margaritis.aggelos.projects.virtualschool.util.ISittable;
import eu.margaritis.aggelos.projects.virtualschool.util.Reference;
import eu.margaritis.aggelos.projects.virtualschool.util.SingularBlockPos;

/**
 * This class, when the player right clicks to the given block, if the block
 * {@link ISittable}, manages the seating of the player on the given block with
 * the given properties.
 * 
 * @author Aggelos
 * 
 * @see RightClickBlock
 * @see SitEvent#onInteractWithBlock(RightClickBlock)
 */
@EventBusSubscriber(modid = Reference.MOD_ID)
public final class SitEvent {

	/**
	 * When this method is being called, if the player and the block fulfil the
	 * requirements to sit, then a new {@link Seat} entity is created which the
	 * player will ride afterwards.
	 * 
	 * @param event
	 * 
	 * @see Seat
	 * @see RightClickBlock
	 * @see ISittable
	 */
	@SubscribeEvent
	@Deprecated
	public static void onInteractWithBlock(RightClickBlock event) {
		EntityPlayer player = event.getEntityPlayer();
		if (player.getRidingEntity() != null) {
			return;
		}
		World world = event.getWorld();
		BlockPos pos = event.getPos();
		Vec3d vec = new Vec3d(pos.getX() + 0.5, pos.getY(), pos.getZ() + 0.5);
		double maxDist = 5;
		if ((vec.x - player.posX) * (vec.x - player.posX) + (vec.y - player.posY) * (vec.y - player.posY) + (vec.z - player.posZ) * (vec.z - player.posZ) > maxDist * maxDist) {
			return;
		}
		IBlockState state = world.getBlockState(pos);
		if (state.getBlock() instanceof ISittable) {
			Seat seat = new Seat(world, pos, ((ISittable) state.getBlock()).getSeatPos());
			if(seat.canBeRidden(player)) {
				world.spawnEntity(seat);
				player.startRiding(seat);
			}
		}
	}

	/**
	 * This class represents an invisible ridable entity at the given position in
	 * the given block which is going to be ridden by a player.
	 * 
	 * @author aggelos
	 * 
	 * @see SitEvent
	 */
	private static final class Seat extends Entity {

		private final IBlockState containingBlock;

		/**
		 * This constructor constructs an invisible ridable entity at the given position
		 * in the given block which is going to be ridden by a player.
		 * 
		 * @param world
		 * @param pos
		 * @param seatPos
		 * 
		 * @see SitEvent
		 */
		public Seat(World world, BlockPos pos, SingularBlockPos seatPos) {
			super(world);
			this.setSize(0.0F, 0.0F);
			this.containingBlock = world.getBlockState(pos);
			this.setPosition(pos.getX() + seatPos.getX(), pos.getY() + seatPos.getY(), pos.getZ() + seatPos.getZ());
		}

		@Override
		public void onUpdate() {
			super.onUpdate();
			BlockPos pos = this.getPosition();
			List<Entity> passengers = this.getPassengers();
			if (this.containingBlock.getBlock() != this.world.getBlockState(pos).getBlock() || passengers.isEmpty()) {
				this.setDead();
				return;
			}
			for (Entity entity : passengers) {
				if (entity.isSneaking()) {
					this.setDead();
					return;
				}
			}
			this.extinguish();
		}
		
		@Override
		public boolean startRiding(Entity entity, boolean force) {
			if(!this.canBeRidden(entity)) {
				this.setDead();
				return false;
			}
			if(super.startRiding(entity)) {
				return true;
			} else {
				this.setDead();
				return false;
			}
		}

		@Override
		protected boolean canBeRidden(Entity entity) {
			if (!super.canBeRidden(entity) || !this.getPassengers().isEmpty() || entity.isSneaking()) {
				return false;
			}
			if (entity instanceof EntityPlayer) {
				if (((EntityPlayer) entity).isSneaking()) {
					return false;
				}
			}
			return true;
		}

		@Override
		protected void entityInit() {

		}

		@Override
		protected void readEntityFromNBT(NBTTagCompound compound) {

		}

		@Override
		protected void writeEntityToNBT(NBTTagCompound compound) {

		}

	}

}
