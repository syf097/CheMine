package com.syf097.chemine.block;

import com.syf097.chemine.block.BlockOre.Type;

import net.minecraft.block.Block;
import net.minecraft.init.Items;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class ItemBlockOre extends ItemBlock {

	public ItemBlockOre(Block block) {

		super(block);
		setHasSubtypes(true);
		setMaxDamage(0);
	}

	@Override
	public String getUnlocalizedName(ItemStack stack) {

		return "tile.chemine.ore." + Type.byMetadata(Items.DIAMOND.getDamage(stack)).getName() + ".name";
	}

	@Override
	public EnumRarity getRarity(ItemStack stack) {

		return Type.byMetadata(Items.DIAMOND.getDamage(stack)).getRarity();
	}
}
