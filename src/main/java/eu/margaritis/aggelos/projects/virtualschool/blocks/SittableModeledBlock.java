package eu.margaritis.aggelos.projects.virtualschool.blocks;

import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.util.math.AxisAlignedBB;

import eu.margaritis.aggelos.projects.virtualschool.util.Reference;
import eu.margaritis.aggelos.projects.virtualschool.util.SingularBlockPos;
import eu.margaritis.aggelos.projects.virtualschool.events.SitEvent;
import eu.margaritis.aggelos.projects.virtualschool.util.ISittable;

/**
 * This class represents a block with a customised json model which is sittable.
 * This block only supports y-axis rotations.
 * 
 * @author Aggelos
 * 
 * @see ISittable
 * @see SitEvent
 * @see BlockBase
 */
public class SittableModeledBlock extends ModeledBlock implements ISittable {

	private final SingularBlockPos height;

	/**
	 * This class represents a block with a customised json model which is sittable.
	 * This block only supports y-axis rotations. The creative tab will be set
	 * automatically to {@link Reference#getMainTab()} and the bounding box will be
	 * set automatically to a full block.
	 * 
	 * @see ISittable
	 * @see SitEvent
	 * @see BlockBase
	 * 
	 * @param name
	 * @param material
	 * @param height
	 */
	public SittableModeledBlock(String name, Material material, SingularBlockPos height) {
		this(name, material, Reference.getMainTab(), new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 1.0D, 1.0D), height);
	}

	/**
	 * This class represents a block with a customised json model which is sittable.
	 * This block only supports y-axis rotations. The creative tab will be set
	 * automatically to {@link Reference#getMainTab()}.
	 * 
	 * @see ISittable
	 * @see SitEvent
	 * @see BlockBase
	 * 
	 * @param name
	 * @param material
	 * @param boundingBox
	 * @param height
	 */
	public SittableModeledBlock(String name, Material material, AxisAlignedBB boundingBox, SingularBlockPos height) {
		this(name, material, Reference.getMainTab(), boundingBox, height);
	}

	/**
	 * This class represents a block with a customised json model which is sittable.
	 * This block only supports y-axis rotations. The bounding box will be set
	 * automatically to a full block.
	 * 
	 * @see ISittable
	 * @see SitEvent
	 * @see BlockBase
	 * 
	 * @param name
	 * @param material
	 * @param tab
	 * @param height
	 */
	public SittableModeledBlock(String name, Material material, CreativeTabs tab, SingularBlockPos height) {
		this(name, material, tab, new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 1.0D, 1.0D), height);
	}

	/**
	 * This class represents a block with a customised json model which is sittable.
	 * This block only supports y-axis rotations.
	 * 
	 * @see ISittable
	 * @see SitEvent
	 * @see BlockBase
	 * 
	 * @param name
	 * @param material
	 * @param tab
	 * @param boundingBox
	 * @param height
	 */
	public SittableModeledBlock(String name, Material material, CreativeTabs tab, AxisAlignedBB boundingBox, SingularBlockPos height) {
		super(name, material, tab, boundingBox);
		this.height = height;
	}

	@Override
	public SingularBlockPos getSeatPos() {
		return height;
	}

}
