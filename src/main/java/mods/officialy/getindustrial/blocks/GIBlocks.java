package mods.officialy.getindustrial.blocks;

import mods.officialy.getindustrial.GetIndustrial;
import mods.officialy.getindustrial.blocks.entities.MissileAssemblerBlockEntity;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

//BlockItems are done in here cause it's makes more sense imo
public class GIBlocks {

    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, GetIndustrial.MODID);
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, GetIndustrial.MODID);

    public static final RegistryObject<Reactor> REACTOR = register("reactor", () -> new Reactor(BlockBehaviour.Properties.of(Material.METAL).strength(4.0f)));

    public static final RegistryObject<Reactor> MISSILE_ASSEMBLER = register("missile_assembler", () -> new Reactor(BlockBehaviour.Properties.of(Material.METAL).strength(4.0f)));

    public static BlockEntityType<MissileAssemblerBlockEntity> MISSILE_ASSEMBLER_BLOCK_ENTITY;

    //Registry.register(Registry.BLOCK_ENTITY_TYPE, new ResourceLocation(GetIndustrial.MOD_ID, "missile_assembler"), BlockEntityType.Builder.of(MissileAssemblerBlockEntity::new, MISSILE_ASSEMBLER).build(null));

    private static <BLOCK extends Block> RegistryObject<BLOCK> register(final String name, final Supplier<BLOCK> blockFactory) {
        return registerBlock(name, blockFactory, block -> new BlockItem(block, defaultItemProperties()));
    }

    private static <BLOCK extends Block> RegistryObject<BLOCK> registerBlock(final String name, final Supplier<BLOCK> blockFactory, final IBlockItemFactory<BLOCK> itemFactory) {
        final RegistryObject<BLOCK> block = BLOCKS.register(name, blockFactory);

        ITEMS.register(name, () -> itemFactory.create(block.get()));

        return block;
    }

    private static Item.Properties defaultItemProperties() {
        return new Item.Properties().tab(GetIndustrial.TAB);
    }

    @FunctionalInterface
    private interface IBlockItemFactory<BLOCK extends Block> {
        Item create(BLOCK block);
    }
}