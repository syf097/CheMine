package com.syf097.chemine.worldgen;

import java.util.Random;

import com.syf097.chemine.block.BlockOre;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.event.terraingen.OreGenEvent;
import net.minecraftforge.event.terraingen.TerrainGen;

public class WorldGenFerrovanadium extends WorldGenerator {
	Block block = BlockOre.getBlockFromName("chemine:ore");
	 private final WorldGenerator worldgenFerrovanadium = new WorldGenMinable(block.getStateFromMeta(1), 16);
	@Override
    public boolean generate(World world, Random rand, BlockPos pos)
    {
        if (TerrainGen.generateOre(world, rand, this, pos, OreGenEvent.GenerateMinable.EventType.CUSTOM))
        {
            for (int i = 0; i < 4; ++i)
            {
                int posX = pos.getX() + rand.nextInt(16);
                int posY = 46 + rand.nextInt(16);
                int posZ = pos.getZ() + rand.nextInt(16);
                BlockPos blockpos = new BlockPos(posX, posY, posZ);
                worldgenFerrovanadium.generate(world, rand, blockpos);
            }
            }
		return true;
        }
}
