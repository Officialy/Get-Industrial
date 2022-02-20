package mods.officialy.getindustrial.blocks.entities;

import mods.officialy.getindustrial.blocks.GIBlocks;
import net.minecraft.client.renderer.texture.Tickable;
import net.minecraft.core.BlockPos;
import net.minecraft.core.NonNullList;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.Container;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.entity.BaseContainerBlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;

public class MissileAssemblerBlockEntity extends BaseContainerBlockEntity implements Container, Tickable {

    public NonNullList<ItemStack> inventory;

    private static final int[] TOP_SLOTS = new int[]{0};
    private static final int[] BOTTOM_SLOTS = new int[]{3};
    private static final int[] SIDE_SLOTS = new int[]{2};
    private static final int[] LEFT_SLOTS = new int[]{1};

    private int burnTime; // Fuel type burn time, like the fire in a furnace
    private int fuelTime; // Amount of time a fuel type will burn - In ticks, ie coal is 1600 ticks / 8 items
    private int processTime; // Amount of cooking taken place, goes up
    private int processTimeSum; // Total time to process a recipe

    public MissileAssemblerBlockEntity(BlockEntityType<?> blockEntityType, BlockPos blockPos, BlockState blockState) {
        super(GIBlocks.MISSILE_ASSEMBLER_BLOCK_ENTITY, blockPos, blockState);
        this.inventory = NonNullList.of(ItemStack.EMPTY); // 1 ? idfk
        this.processTime = 0;
        this.processTimeSum = 0;
        this.fuelTime = 0;
        this.burnTime = 0;
    }

    @Override
    protected Component getDefaultName() {
        return null;
    }

    @Override
    protected AbstractContainerMenu createMenu(int i, Inventory inventory) {
        return null;
    }

    @Override
    public int getContainerSize() {
        return 1;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public ItemStack getItem(int i) {
        return null;
    }

    @Override
    public ItemStack removeItem(int i, int j) {
        return null;
    }

    @Override
    public ItemStack removeItemNoUpdate(int i) {
        return null;
    }

    @Override
    public void setItem(int i, ItemStack itemStack) {

    }

    @Override
    public boolean stillValid(Player player) {
        return false;
    }

    @Override
    public void clearContent() {

    }

    @Override
    public void tick() {

    }
}
