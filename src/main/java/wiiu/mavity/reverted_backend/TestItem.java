package wiiu.mavity.reverted_backend;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.*;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.util.*;
import net.minecraft.world.World;

import org.jetbrains.annotations.NotNull;

public class TestItem extends Item {

    public TestItem(Item.Settings settings) {
        super(settings);
    }

    @Override
    public boolean hasGlint(ItemStack stack) {
        return true;
    }

    @Override
    public TypedActionResult<ItemStack> use(@NotNull World world, @NotNull PlayerEntity user, @NotNull Hand hand) {

        ItemStack stack = user.getMainHandStack();
        if (!stack.hasNbt() && !world.isClient()) {

            addTest(user);
            System.out.println(stack.getNbt());
            return TypedActionResult.consume(stack);

        } else {

            return TypedActionResult.fail(stack); // Can't have a runtime exception here anymore due to the nature of the if statement logic.

        }
    }

    public void addTest(@NotNull PlayerEntity player) {
        ItemStack stack = player.getStackInHand(player.getActiveHand());

        NbtCompound nbtData = new NbtCompound();
        nbtData.putString("reverted_backend.test_item.used", "test");

        stack.setNbt(nbtData);
    }
}