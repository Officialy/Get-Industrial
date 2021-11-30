package mods.officialy.getindustrial.blocks;

import mods.officialy.getindustrial.blocks.entities.menu.MissileMenu;
import mods.officialy.getindustrial.recipe.MissileRecipe;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Registry;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.util.LazyLoadedValue;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.SimpleMenuProvider;
import net.minecraft.world.inventory.ContainerLevelAccess;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.Nullable;

public class MissileAssembler extends Block {

    private final MenuType<MissileMenu> menuType;
    private final RecipeType<MissileRecipe> recipeType;
    private final LazyLoadedValue<Component> containerName;

    public MissileAssembler(MenuType<MissileMenu> menuType, RecipeType<MissileRecipe> recipeType, Properties properties) {
        super(properties);
        this.menuType = menuType;
        this.recipeType = recipeType;
        containerName = new LazyLoadedValue<>(() -> new TranslatableComponent("container.getindustrial." + Registry.BLOCK.getKey(MissileAssembler.this).getPath()));

    }

    @Override
    public boolean hasDynamicShape() {
        return true;
    }

    @Override
    public VoxelShape getVisualShape(BlockState blockState, BlockGetter blockGetter, BlockPos blockPos, CollisionContext collisionContext) {
        return super.getVisualShape(blockState, blockGetter, blockPos, collisionContext);
    }

    @Nullable
    @Override
    public MenuProvider getMenuProvider(BlockState blockState, Level level, BlockPos blockPos) {
        return new SimpleMenuProvider(
                (id, inventory, player) -> new MissileMenu(id, inventory, menuType, recipeType, ContainerLevelAccess.create(level, blockPos), this),
                containerName.get()
        );
    }
}
