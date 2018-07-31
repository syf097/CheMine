package com.syf097.chemine.loader;

import com.syf097.chemine.chemine;
import com.syf097.chemine.block.fluid.BlockFluidCoalGas;
import com.syf097.chemine.fluid.FluidCoalGas;
import com.syf097.chemine.fluid.FluidNitrogen;

import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.ItemMeshDefinition;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.renderer.block.statemap.StateMapperBase;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fluids.BlockFluidBase;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class FluidLoader {
	public static Fluid fluidCoalGas = new FluidCoalGas();
	public static Fluid fluidNitrogen = new FluidNitrogen();
	 public FluidLoader(FMLPreInitializationEvent event)
	    {
	            FluidRegistry.registerFluid(fluidCoalGas);
	            FluidRegistry.registerFluid(fluidNitrogen);
	    }
	    @SideOnly(Side.CLIENT)
	    public static void registerRenders()
	    {
	        registerFluidRender((BlockFluidBase)BlockLoader.blockfluidcoalgas , "fluid_coalgas");
	    }

	    @SideOnly(Side.CLIENT)
	    public static void registerFluidRender(BlockFluidBase blockFluid, String blockStateName)
	    {
	        final String location = chemine.MODID + ":" + blockStateName;
	        final Item itemFluid = Item.getItemFromBlock(blockFluid);
	        ModelLoader.setCustomMeshDefinition(itemFluid, new ItemMeshDefinition()
	        {
	            @Override
	            public ModelResourceLocation getModelLocation(ItemStack stack)
	            {
	                return new ModelResourceLocation(location, "fluid");
	            }
	        });
	        ModelLoader.setCustomStateMapper(blockFluid, new StateMapperBase()
	        {
	            @Override
	            protected ModelResourceLocation getModelResourceLocation(IBlockState state)
	            {
	                return new ModelResourceLocation(location, "fluid");
	            }
	        });
	    }
}
