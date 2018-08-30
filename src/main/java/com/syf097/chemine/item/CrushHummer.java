package com.syf097.chemine.item;

import java.util.Set;

import com.google.common.collect.Sets;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemTool;
import net.minecraftforge.fml.common.registry.ForgeRegistries;

public class CrushHummer extends ItemTool {
	private static final Set<Block> EFFECTIVE_ON = Sets.newHashSet(Blocks.ACTIVATOR_RAIL, Blocks.COAL_ORE, Blocks.COBBLESTONE, Blocks.DETECTOR_RAIL, Blocks.DIAMOND_BLOCK, Blocks.DIAMOND_ORE, Blocks.DOUBLE_STONE_SLAB, Blocks.GOLDEN_RAIL, Blocks.GOLD_BLOCK, Blocks.GOLD_ORE, Blocks.ICE, Blocks.IRON_BLOCK, Blocks.IRON_ORE, Blocks.LAPIS_BLOCK, Blocks.LAPIS_ORE, Blocks.LIT_REDSTONE_ORE, Blocks.MOSSY_COBBLESTONE, Blocks.NETHERRACK, Blocks.PACKED_ICE, Blocks.RAIL, Blocks.REDSTONE_ORE, Blocks.SANDSTONE, Blocks.RED_SANDSTONE, Blocks.STONE, Blocks.STONE_SLAB, Blocks.STONE_BUTTON, Blocks.STONE_PRESSURE_PLATE);

 public CrushHummer( Item.ToolMaterial materialIn ){
	 super( 1.0F, -2.8F, materialIn, EFFECTIVE_ON);
	 this.setUnlocalizedName("crushhummer");
	 this.maxStackSize = 1;
     this.setMaxDamage(materialIn.getMaxUses());
 }
	public boolean preInit() {
		this.setRegistryName("crushhummer");
		 ForgeRegistries.ITEMS.register(this);
		return true;
	}
	 public boolean canHarvestBlock(IBlockState blockIn)
	    {
			return true;

	    }
}
