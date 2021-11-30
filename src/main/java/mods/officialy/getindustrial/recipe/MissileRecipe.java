package mods.officialy.getindustrial.recipe;

import com.google.gson.JsonObject;
import com.mojang.realmsclient.util.JsonUtils;
import net.minecraft.core.Registry;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.GsonHelper;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;

import java.util.function.Predicate;

public class MissileRecipe implements Recipe<Inventory> {

    private final ResourceLocation resourceLocation;
    private final Predicate<ItemStack> firstInput;
    private final ItemStack firstOutput;
    private final int time;

    public MissileRecipe(ResourceLocation resourceLocation, Predicate<ItemStack> firstInput, ItemStack output, int time) {
        this.resourceLocation = resourceLocation;
        this.firstInput = firstInput;
        this.firstOutput = output;
        this.time = time;
    }

    @Override
    public boolean isSpecial() {
        return true;
    }

    @Override
    public ResourceLocation getId() {
        return resourceLocation;
    }

    @Override
    public boolean matches(Inventory container, Level level) {
        return false;
    }

    @Override
    public ItemStack assemble(Inventory container) {
        return ItemStack.EMPTY;
    }

    @Override
    public boolean canCraftInDimensions(int i, int j) {
        return false;
    }

    @Override
    public ItemStack getResultItem() {
        return ItemStack.EMPTY;
    }

    @Override
    public RecipeSerializer<?> getSerializer() {
        return null;
    }

    @Override
    public RecipeType<?> getType() {
        return null;
    }

    public record Serializer() implements RecipeSerializer<MissileRecipe> {
        public static final ResourceLocation ID = new ResourceLocation("missileassemble");
        public static final Serializer INSTANCE = new Serializer();

        public MissileRecipe fromJson(ResourceLocation recipeId, JsonObject json) {
            String s = JsonUtils.getStringOr("group", json, "");
            Ingredient ingredient;
            if (GsonHelper.isArrayNode(json, "ingredient")) {
                ingredient = Ingredient.fromJson(GsonHelper.getAsJsonArray(json, "ingredient"));
            } else {
                ingredient = Ingredient.fromJson(GsonHelper.getAsJsonObject(json, "ingredient"));
            }

            String s1 = GsonHelper.getAsString(json, "result");
            int i = GsonHelper.getAsInt(json, "count");
            ItemStack itemstack = new ItemStack(Registry.ITEM.get(new ResourceLocation(s1)), i);
            return new MissileRecipe(recipeId, ingredient, itemstack, 5);
        }

        public MissileRecipe fromNetwork(ResourceLocation recipeId, FriendlyByteBuf buffer) {
            String s = buffer.readUtf(32767);
            Ingredient ingredient = Ingredient.fromNetwork(buffer);
            ItemStack itemstack = buffer.readItem();
            return new MissileRecipe(recipeId, ingredient, itemstack, 5);
        }

        public void toNetwork(FriendlyByteBuf buffer, MissileRecipe recipe) {
            buffer.writeUtf(recipe.getGroup());

            buffer.writeItem(recipe.getResultItem());
        }
    }
}
