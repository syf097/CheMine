package com.syf097.chemine.block;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IStringSerializable;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockOre extends Block {
	public static final PropertyEnum<Type> VARIANT = PropertyEnum.create("type", Type.class);
	public BlockOre() {
		super(Material.ROCK);

		setUnlocalizedName("ore");
		setCreativeTab(CreativeTabs.BUILDING_BLOCKS);

		setHardness(3.0F);
		setResistance(5.0F);
		setSoundType(SoundType.STONE);
		setDefaultState(this.blockState.getBaseState().withProperty(VARIANT, Type.PYSITE));

		setHarvestLevel("pickaxe", 2);
		setHarvestLevel("pickaxe", 1, getStateFromMeta(Type.PYSITE.getMetadata()));
	}
	@Override
	protected BlockStateContainer createBlockState() {

		return new BlockStateContainer(this, VARIANT);
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

	@Override
	public int getLightValue(IBlockState state, IBlockAccess world, BlockPos pos) {

		return state.getValue(VARIANT).getLight();
	}
	public boolean preInit() {

		this.setRegistryName("ore");
		ForgeRegistries.BLOCKS.register(this);

		ItemBlockOre itemBlock = new ItemBlockOre(this);
		itemBlock.setRegistryName(this.getRegistryName());
		ForgeRegistries.ITEMS.register(itemBlock);

		
		return true;
	}
	@SideOnly (Side.CLIENT)
	public void registerModels() {

		for (int i = 0; i < Type.values().length; i++) {
			ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(this), i, new ModelResourceLocation("chemine:ore", "type=" + Type.byMetadata(i).getName()));
		}
	}
	
	public enum Type implements IStringSerializable {
		
		
		PYSITE(0, "pysite"),
		FERROVANADIUM(1,"ferrovanadium");
		
		private static final Type[] METADATA_LOOKUP = new Type[values().length];
		private final int metadata;
		private final String name;
		private final int light;
		

		Type(int metadata, String name, int light) {

			this.metadata = metadata;
			this.name = name;
			this.light = light;

		}

		

		Type(int metadata, String name) {

			this(metadata, name, 0);
		}

		public int getMetadata() {

			return this.metadata;
		}

		@Override
		public String getName() {

			return this.name;
		}

		public int getLight() {

			return this.light;
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

