package mods.officialy.getindustrial.recipe;

import com.google.gson.JsonObject;
import net.minecraft.core.Registry;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.*;

public interface RecipeTypes<T extends Recipe<?>> extends net.minecraftforge.registries.IForgeRegistryEntry<RecipeSerializer<?>>  {

    RecipeSerializer<MissileRecipe> MISSILE = register("crafting_shaped", new MissileRecipe.Serializer());


    T fromJson(ResourceLocation p_44103_, JsonObject p_44104_);

    @javax.annotation.Nullable
    T fromNetwork(ResourceLocation p_44105_, FriendlyByteBuf p_44106_);

    void toNetwork(FriendlyByteBuf p_44101_, T p_44102_);

    static <S extends RecipeSerializer<T>, T extends Recipe<?>> S register(String p_44099_, S p_44100_) {
        return Registry.register(Registry.RECIPE_SERIALIZER, p_44099_, p_44100_);
    }
}
