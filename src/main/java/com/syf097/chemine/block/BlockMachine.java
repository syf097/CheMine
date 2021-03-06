package com.syf097.chemine.block;

import com.syf097.chemine.chemine;
import com.syf097.chemine.item.Resource;
import com.syf097.chemine.tile.TileLeacher;
import com.syf097.chemine.tile.TileSeparator;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.IStringSerializable;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fluids.capability.CapabilityFluidHandler;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;

public class BlockMachine extends BlockContainer{
	public static final PropertyEnum<Type> VARIANT = PropertyEnum.create("machine", Type.class);
	public BlockMachine(){
		super(Material.IRON);

		setUnlocalizedName("machine");
		setDefaultState(getBlockState().getBaseState().withProperty(VARIANT, Type.SEPARATOR));
		setHardness(15.0F);
		setResistance(25.0F);
		
	}

	@Override
	public TileEntity createNewTileEntity(World worldIn, int meta) {
	
		switch (Type.byMetadata(meta)) {
		case  SEPARATOR:
			return new TileSeparator();
		case LEACHER:
			return new TileLeacher();
		default:
			return null;
		}
	}
	@Override
	protected BlockStateContainer createBlockState() {

		BlockStateContainer.Builder builder = new BlockStateContainer.Builder(this);
		// Listed
		builder.add(VARIANT);
		// UnListed
		return builder.build();
	}
	@Override
	public IBlockState getStateFromMeta(int meta) {

		return this.getDefaultState().withProperty(VARIANT, Type.byMetadata(meta));
	}

	@Override
	public int getMetaFromState(IBlockState state) {

		return state.getValue(VARIANT).getMetadata();
	}

	@Override
	public int damageDropped(IBlockState state) {

		return state.getValue(VARIANT).getMetadata();
	}
	public  void preinit() {
	this.setRegistryName("machine");
	ForgeRegistries.BLOCKS.register(this);

	ItemBlockMachine itemBlock = new ItemBlockMachine(this);
	itemBlock.setRegistryName(this.getRegistryName());
	ForgeRegistries.ITEMS.register(itemBlock);
	}
	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ)
	    {
		 if (!worldIn.isRemote)
	        {
	            TileLeacher te = (TileLeacher) worldIn.getTileEntity(pos);
	           
	            IItemHandler inv = te.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, EnumFacing.DOWN);
	            String msg = String.format("Up: %s",inv.getStackInSlot(0));
	            chemine.instance.getLogger().info(msg);
	        }
	        return true;
		 
	    }
	 public void getSubBlocks(CreativeTabs itemIn, NonNullList<ItemStack> items)
	    {
		 for(int i=0;i<Type.values() .length;i++)
	        	items.add(new ItemStack(this,1,i));
	    }
	
	public enum Type implements IStringSerializable {
	    SEPARATOR(0,"separator"),
		LEACHER(1,"leacher");
		private static final Type[] METADATA_LOOKUP = new Type[values().length];
		private final int metadata;
		private final String name;

		Type(int metadata, String name) {

			this.metadata = metadata;
			this.name = name;
		}

		public int getMetadata() {

			return this.metadata;
		}

		@Override
		public String getName() {

			return this.name;
		}

		public static Type byMetadata(int metadata) {

			if (metadata < 0 || metadata >= METADATA_LOOKUP.length) {
				metadata = 0;
			}
			return METADATA_LOOKUP[metadata];
		}

		static {
			for (Type type : values()) {
				METADATA_LOOKUP[type.getMetadata()] = type;
			}
		}
	}
}
