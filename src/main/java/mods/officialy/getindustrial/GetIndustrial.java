package mods.officialy.getindustrial;

import mods.officialy.getindustrial.blocks.GIBlocks;
import mods.officialy.getindustrial.items.GIItems;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(GetIndustrial.MODID)
public class GetIndustrial {

    public static final String MODID = "getindustrial";
    public static final Logger LOGGER = LogManager.getLogger();
    public static final CreativeModeTab TAB = new CreativeModeTab("getindustrial") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(GIBlocks.REACTOR.get().asItem());
        }
    };

    public GetIndustrial() {
        final IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        MinecraftForge.EVENT_BUS.register(this);
        modEventBus.addListener(this::commonSetup);
        modEventBus.addListener(this::clientSetup);

        GIBlocks.BLOCKS.register(modEventBus);
    }

    public void commonSetup(final FMLCommonSetupEvent evt) {
        LOGGER.info("Loading [Get Industrial]");

        LOGGER.info("[Get Industrial] has successfully been loaded!");
    }

    public void clientSetup(final FMLClientSetupEvent evt) {

    }
}
