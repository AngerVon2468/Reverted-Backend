package wiiu.mavity.reverted_backend.interfaces;

import net.minecraft.nbt.NbtCompound;

public interface INbtInjection {

    default NbtCompound getOrCreateNbt() {
        return new NbtCompound();
    };

    default void setNbt(NbtCompound nbt) {};

    default void writeNbt(NbtCompound nbt) {};
}