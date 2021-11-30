package mods.officialy.getindustrial;

import mods.officialy.getindustrial.blocks.GIBlocks;
import mods.officialy.getindustrial.items.GIItems;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class GetIndustrial implements ModInitializer {

    public static final String MOD_ID = "getindustrial";
    public static final Logger LOGGER = LogManager.getLogger();
    public static final CreativeModeTab TAB = FabricItemGroupBuilder.create(new ResourceLocation(MOD_ID, "main")).icon(() -> new ItemStack(GIBlocks.REACTOR_ITEM)).build();

    @Override
    public void onInitialize() {
        registerEvents();

    }

    public static void load() {
        LOGGER.info("Loading [Get Industrial]");

        LOGGER.info("[Get Industrial] has successfully been loaded!");
    }

    private void registerEvents() {
        GIBlocks.register();
        GIItems.register();

    }

    public static ResourceLocation ID(String name) {
        return new ResourceLocation("getindustrial", name);
    }
}
