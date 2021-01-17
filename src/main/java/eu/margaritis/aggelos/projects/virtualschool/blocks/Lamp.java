package eu.margaritis.aggelos.projects.virtualschool.blocks;

import net.minecraft.block.material.Material;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import eu.margaritis.aggelos.projects.virtualschool.util.Reference;

/**
 * This class represents a {@link ModeledBlock} in the shape of a lamp with
 * different settings from {@link ModeledBlock}.
 * 
 * @see ModeledBlock
 * 
 * @author Aggelos
 */
public class Lamp extends ModeledBlock {

	/**
	 * This constructor constructs a new  {@link ModeledBlock} in the shape of a lamp with
	 * different settings from {@link ModeledBlock}.
	 * 
	 * @see ModeledBlock
	 */
	public Lamp() {
		super("lamp", Material.GLASS, Reference.getMainTab(), new AxisAlignedBB(0.0625D, 0.8125D, 0.0625D, 0.953125D, 1.0D, 0.9375D));
		this.setLightLevel(150000000F);
		this.setLightOpacity(1);
	}

	@Override
	public boolean canBlockStay(World worldIn, BlockPos pos) {
		return worldIn.getBlockState(pos.up()).isSideSolid(worldIn, pos, EnumFacing.DOWN);
	}

}
