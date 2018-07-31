package com.syf097.chemine.block;

import com.syf097.chemine.tile.TileSeparator;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IStringSerializable;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.ForgeRegistries;

public class BlockMachine extends BlockContainer{
	public static final PropertyEnum<Type> VARIANT = PropertyEnum.create("type", Type.class);
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
	
	
	
	
	public enum Type implements IStringSerializable {
	    SEPARATOR(0,"separator");
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
