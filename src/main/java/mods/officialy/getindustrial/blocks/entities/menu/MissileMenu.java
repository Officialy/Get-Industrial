package mods.officialy.getindustrial.blocks.entities.menu;

import com.google.common.collect.Lists;
import mods.officialy.getindustrial.recipe.MissileRecipe;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.*;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.api.distmarker.OnlyIn;

import java.util.List;

public class MissileMenu extends AbstractContainerMenu {

    private final ContainerLevelAccess access;
    private final DataSlot selectedRecipeIndex;
    private final Level level;
    private List<MissileRecipe> recipes = Lists.newArrayList();
    private ItemStack input = ItemStack.EMPTY;
    private long lastSoundTime;
    final Slot inputSlot;
    final Slot resultSlot;
    private Runnable slotUpdateListener;
    public final CraftingContainer container;

    private final ResultContainer resultContainer = new ResultContainer();

    private final MenuType<MissileMenu> containerType;
    private final RecipeType<MissileRecipe> recipeType;
    private final Block blockWorkbench;

    public MissileMenu(int id, Inventory inventory, MenuType<MissileMenu> menuType, RecipeType<MissileRecipe> recipeType, Block block) {
        this(id, inventory, menuType, recipeType, ContainerLevelAccess.NULL, block);
    }

    public MissileMenu(int id, Inventory inventory, MenuType<MissileMenu> menuType, RecipeType<MissileRecipe> recipeType, ContainerLevelAccess access, Block block) {
        super(menuType, id);
        this.selectedRecipeIndex = DataSlot.standalone();
        this.slotUpdateListener = () -> {
        };
        this.container = new CraftingContainer(this, 64, 64) {
            public void setChanged() {
                super.setChanged();
                MissileMenu.this.slotsChanged(this);
                MissileMenu.this.slotUpdateListener.run();
            }
        };
        containerType = menuType;
        this.access = access;
        this.level = inventory.player.level;
        this.recipeType = recipeType;
        this.blockWorkbench = block;
        this.inputSlot = this.addSlot(new Slot(this.container, 0, 20, 33));
        this.resultSlot = this.addSlot(new Slot(this.resultContainer, 1, 143, 33) {
            public boolean mayPlace(ItemStack itemStack) {
                return false;
            }

            public void onTake(Player player, ItemStack itemStack) {
                itemStack.onCraftedBy(player.level, player, itemStack.getCount());
                MissileMenu.this.resultContainer.awardUsedRecipes(player);
                ItemStack itemStack2 = MissileMenu.this.inputSlot.remove(1);

                access.execute((level, blockPos) -> {
                    long l = level.getGameTime();
                    if (MissileMenu.this.lastSoundTime != l) {
                        level.playSound(null, blockPos, SoundEvents.UI_STONECUTTER_TAKE_RESULT, SoundSource.BLOCKS, 1.0F, 1.0F);
                        MissileMenu.this.lastSoundTime = l;
                    }

                });
                super.onTake(player, itemStack);
            }
        });

        for (int i = 0; i < 3; ++i) {
            for (int j = 0; j < 9; ++j) {
                this.addSlot(new Slot(inventory, j + i * 9 + 9, 8 + j * 18, 84 + i * 18));
            }
        }

        for (int k = 0; k < 9; ++k) {
            this.addSlot(new Slot(inventory, k, 8 + k * 18, 142));
        }

        this.addDataSlot(this.selectedRecipeIndex);
    }

    public int getSelectedRecipeIndex() {
        return this.selectedRecipeIndex.get();
    }

    public List<MissileRecipe> getRecipes() {
        return this.recipes;
    }

    public int getNumRecipes() {
        return this.recipes.size();
    }

    public boolean hasInputItem() {
        return this.inputSlot.hasItem() && !this.recipes.isEmpty();
    }

    @Override
    public boolean stillValid(Player player) {
        return stillValid(this.access, player, blockWorkbench);
    }


    private boolean isValidRecipeIndex(int index) {
        return index >= 0 && index < this.recipes.size();
    }


    @Override
    public MenuType<?> getType() {
        return containerType;
    }

    public void registerUpdateListener(Runnable p_217071_1_) {
        this.slotUpdateListener = p_217071_1_;
    }

    @Override
    public boolean canTakeItemForPickAll(ItemStack stack, Slot slot) {
        return slot.container != this.resultContainer && super.canTakeItemForPickAll(stack, slot);
    }

    @Override
    public void removed(Player player) {
        super.removed(player);
        this.resultContainer.removeItemNoUpdate(1);
        this.access.execute((level, blockPos) -> {
            this.clearContainer(player, this.container);
        });
    }
}
