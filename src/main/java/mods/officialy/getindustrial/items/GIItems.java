package mods.officialy.getindustrial.items;

import mods.officialy.getindustrial.GetIndustrial;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;

public class GIItems {

    public static final Item genericitem = new Item(new Item.Properties().tab(GetIndustrial.TAB));


    public static void register(){
        Registry.register(Registry.ITEM, new ResourceLocation("getindustrial", "genericitem"), genericitem);

    }

}
