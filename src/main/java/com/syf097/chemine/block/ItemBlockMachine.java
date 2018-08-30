package com.syf097.chemine.block;

import java.util.ArrayList;
import java.util.List;

import com.syf097.chemine.block.BlockMachine.Type;

import ic2.api.tile.IWrenchable;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class ItemBlockMachine extends ItemBlock   {
	public ItemBlockMachine(Block block) {

		super(block);
		setHasSubtypes(true);
		setMaxDamage(0);
	}
	
	@Override
	public String getUnlocalizedName(ItemStack stack) {

		return "tile.chemine.machine." + Type.byMetadata(Items.DIAMOND.getDamage(stack)).getName() + ".name";
	}

	public int getMetadata(int damage)
    {
        return damage;
    }

   
}
