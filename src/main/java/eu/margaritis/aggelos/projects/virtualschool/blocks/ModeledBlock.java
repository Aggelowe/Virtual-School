package eu.margaritis.aggelos.projects.virtualschool.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.inventory.InventoryHelper;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

import eu.margaritis.aggelos.projects.virtualschool.util.IRotatable;
import eu.margaritis.aggelos.projects.virtualschool.util.Reference;

/**
 * This class represents a block with a customised json model. This block only
 * supports y-axis rotations.
 * 
 * @author Aggelos
 * 
 * @see BlockBase
 */
public class ModeledBlock extends BlockBase implements IRotatable {

	private final AxisAlignedBB boundingBox;

	private static final PropertyDirection FACING = PropertyDirection.create("facing", EnumFacing.Plane.HORIZONTAL);

	/**
	 * This constructor constructs a new block with a customised json model. This
	 * block only supports y-axis rotations. The creative tab will be set
	 * automatically to {@link Reference#getMainTab()} and the bounding box will be
	 * set automatically to a full block.
	 * 
	 * @see BlockBase
	 * 
	 * @param name
	 * @param material
	 */
	public ModeledBlock(String name, Material material) {
		this(name, material, Reference.getMainTab(), new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 1.0D, 1.0D));
	}

	/**
	 * This constructor constructs a new block with a customised json model. This
	 * block only supports y-axis rotations. The creative tab will be set
	 * automatically to {@link Reference#getMainTab()}.
	 * 
	 * @see BlockBase
	 * 
	 * @param name
	 * @param material
	 * @param boundingBox
	 */
	public ModeledBlock(String name, Material material, AxisAlignedBB boundingBox) {
		this(name, material, Reference.getMainTab(), boundingBox);
	}

	/**
	 * This constructor constructs a new block with a customised json model. This
	 * block only supports y-axis rotations. The bounding box will be set
	 * automatically to a full block.
	 * 
	 * @see BlockBase
	 * 
	 * @param name
	 * @param material
	 * @param tab
	 */
	public ModeledBlock(String name, Material material, CreativeTabs tab) {
		this(name, material, tab, new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 1.0D, 1.0D));
	}

	/**
	 * This constructor constructs a new block with a customised json model. This
	 * block only supports y-axis rotations.
	 * 
	 * @see BlockBase
	 * 
	 * @param name
	 * @param material
	 * @param tab
	 * @param boundingBox
	 */
	public ModeledBlock(String name, Material material, CreativeTabs tab, AxisAlignedBB boundingBox) {
		super(name, material, tab);
		this.boundingBox = boundingBox;
		this.setDefaultState(blockState.getBaseState().withProperty(FACING, EnumFacing.NORTH));
	}

	@Override
	public IBlockState getStateFromMeta(int meta) {
		EnumFacing facing = EnumFacing.getFront(meta);
		if (facing.getAxis() == EnumFacing.Axis.Y) {
			facing = EnumFacing.NORTH;
		}
		return getDefaultState().withProperty(FACING, facing);
	}

	@Override
	public int getMetaFromState(IBlockState state) {
		return ((EnumFacing) state.getValue(FACING)).getIndex();
	}

	@Override
	protected BlockStateContainer createBlockState() {
		return new BlockStateContainer(this, new IProperty[] { FACING });
	}

	@Override
	public boolean canPlaceBlockAt(World worldIn, BlockPos pos) {
		return super.canPlaceBlockAt(worldIn, pos) ? this.canBlockStay(worldIn, pos) : false;
	}

	@Override
	public void neighborChanged(IBlockState state, World worldIn, BlockPos pos, Block blockIn, BlockPos fromPos) {
		if (!this.canBlockStay(worldIn, pos)) {
			worldIn.setBlockToAir(pos);
			InventoryHelper.spawnItemStack(worldIn, pos.getX(), pos.getY(), pos.getZ(), new ItemStack(this));
		}
	}

	/**
	 * This method checks if the given block in the given world can stay where it is
	 * or where it was going to be placed.
	 * 
	 * @param worldIn
	 * @param pos
	 * @return
	 */
	public boolean canBlockStay(World worldIn, BlockPos pos) {
		return worldIn.getBlockState(pos.down()).isSideSolid(worldIn, pos, EnumFacing.UP);
	}

	@Override
	public BlockRenderLayer getBlockLayer() {
		return BlockRenderLayer.CUTOUT;
	}

	@Override
	public boolean isOpaqueCube(IBlockState state) {
		return false;
	}

	@Override
	public boolean isFullCube(IBlockState state) {
		return false;
	}

	@Override
	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {
		return boundingBox;
	}

}
