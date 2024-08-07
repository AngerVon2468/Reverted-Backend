package wiiu.mavity.reverted_backend.interfaces;

import net.minecraft.nbt.NbtCompound;

public interface INbtInjection {

    default NbtCompound getOrCreateNbt() {
        return new NbtCompound();
    }

    default void setNbt(NbtCompound nbt) {}

    default NbtCompound getNbt() {
        return new NbtCompound();
    }

    default NbtCompound backupGetNbt() {
        return new NbtCompound();
    }

    default boolean hasNbt() {
        return false;
    };

    default void removeSubNbt(String string) {}
}