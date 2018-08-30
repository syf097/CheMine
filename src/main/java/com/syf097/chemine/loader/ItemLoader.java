package com.syf097.chemine.loader;

import com.syf097.chemine.item.CrushHummer;
import com.syf097.chemine.item.QuantumSaber;
import com.syf097.chemine.item.dust;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemLoader {
	public static CrushHummer hummer = new CrushHummer(ToolMaterial.STONE);
	public static dust dust = new dust();
	public static QuantumSaber saber = new QuantumSaber();
	public ItemLoader(FMLPreInitializationEvent event)
	    {
		dust.preInit();
		hummer.preInit();
		saber.preInit();
	    }
	public static void render() {
		registerRender(saber);
	}

    @SideOnly(Side.CLIENT)
    private static void registerRender(Item item)
    {
        ModelResourceLocation model = new ModelResourceLocation(item.getRegistryName(), "inventory");
        ModelLoader.setCustomModelResourceLocation(item, 0, model);
    }
}
