package net.wapit1.tfc_tweaked_nutrition;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.config.ModConfigEvent;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

// An example config class. This is not required, but it's a good idea to have one to keep your config organized.
// Demonstrates how to use Forge's config APIs
@Mod.EventBusSubscriber(modid = "tfc_tweaked_nutrition", bus = Mod.EventBusSubscriber.Bus.MOD)
public class Config {
/*
configurable drain rate of nutrition
configurable starting nutrition
configurable max raw
configurable curve sharpness

 */

    @SubscribeEvent
    static void onLoad(final ModConfigEvent event)
    {

    }
}
