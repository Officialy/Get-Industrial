package mods.officialy.getindustrial.blocks;

import mods.officialy.getindustrial.GetIndustrial;
import mods.officialy.getindustrial.blocks.entities.MissileAssemblerBlockEntity;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.material.Material;

//BlockItems are done in here cause it's makes more sense imo
public class GIBlocks {

    public static final Block REACTOR = new Reactor(FabricBlockSettings.of(Material.METAL).strength(4.0f));
    public static final Item REACTOR_ITEM = new BlockItem(REACTOR, new Item.Properties().tab(GetIndustrial.TAB));

    public static final Block MISSILE_ASSEMBLER = new Reactor(FabricBlockSettings.of(Material.METAL).strength(4.0f));
    public static final Item MISSILE_ASSEMBLER_ITEM = new BlockItem(REACTOR, new Item.Properties().tab(GetIndustrial.TAB));

    public static BlockEntityType<MissileAssemblerBlockEntity> MISSILE_ASSEMBLER_BLOCK_ENTITY;

    public static void register(){
        Registry.register(Registry.BLOCK, new ResourceLocation(GetIndustrial.MOD_ID, "reactor"), REACTOR);
        Registry.register(Registry.ITEM, new ResourceLocation(GetIndustrial.MOD_ID, "reactor"), REACTOR_ITEM);

        Registry.register(Registry.BLOCK, new ResourceLocation(GetIndustrial.MOD_ID, "missile_assembler"), MISSILE_ASSEMBLER);
        Registry.register(Registry.ITEM, new ResourceLocation(GetIndustrial.MOD_ID, "missile_assembler"), MISSILE_ASSEMBLER_ITEM);
        
        //Registry.register(Registry.BLOCK_ENTITY_TYPE, new ResourceLocation(GetIndustrial.MOD_ID, "missile_assembler"), BlockEntityType.Builder.of(MissileAssemblerBlockEntity::new, MISSILE_ASSEMBLER).build(null));

    }

}