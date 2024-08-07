package wiiu.mavity.reverted_backend.mixin;

import net.minecraft.component.*;
import net.minecraft.component.type.NbtComponent;
import net.minecraft.item.*;
import net.minecraft.nbt.NbtCompound;

import org.jetbrains.annotations.Nullable;

import org.spongepowered.asm.mixin.*;

import wiiu.mavity.reverted_backend.RevertedBackendDataComponentTypes;
import wiiu.mavity.reverted_backend.interfaces.INbtInjection;

@Mixin(ItemStack.class)
public abstract class ItemMixin implements INbtInjection {

	@Shadow @Nullable public abstract <T> T set(ComponentType<? super T> type, @Nullable T value);

	@Shadow public abstract boolean isEmpty();

	@Unique
	@Nullable
	private NbtCompound nbt = null;

	@Override
	public NbtCompound getOrCreateNbt() {
		if (this.nbt == null) {
			this.nbt = new NbtCompound();
			this.set(RevertedBackendDataComponentTypes.NBT, NbtComponent.of(this.nbt));
        } else {
			this.nbt = ((ComponentHolder)this).getOrDefault(RevertedBackendDataComponentTypes.NBT, NbtComponent.DEFAULT).copyNbt();
		}
        return this.nbt;
    }

	@Override
	@Nullable
	public NbtCompound getNbt() {
		this.nbt = ((ComponentHolder)this).getOrDefault(RevertedBackendDataComponentTypes.NBT, NbtComponent.DEFAULT).copyNbt();
		return this.nbt;
	}

	@Override
	@Nullable
	public NbtCompound backupGetNbt() {
		return this.nbt;
	}

	@Override
	public void setNbt(NbtCompound nbt) {
		this.nbt = nbt;
		this.set(RevertedBackendDataComponentTypes.NBT, NbtComponent.of(this.nbt));
	}

	@Override
	public boolean hasNbt() {
		return !this.isEmpty() && this.nbt != null && !this.nbt.isEmpty();
	}

	@Override
	public void removeSubNbt(String string) {
		if (this.nbt != null && this.nbt.contains(string)) {
			this.nbt.remove(string);
			if (this.nbt.isEmpty()) {
				this.nbt = null;
			}
		}
	}
}