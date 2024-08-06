package wiiu.mavity.reverted_backend.mixin;

import net.minecraft.item.Item;
import net.minecraft.nbt.NbtCompound;

import org.spongepowered.asm.mixin.Mixin;

import wiiu.mavity.reverted_backend.interfaces.INbtInjection;

@Mixin(Item.class)
public class ItemMixin implements INbtInjection {

	private NbtCompound nbt;

	@Override
	public NbtCompound getOrCreateNbt() {
		if (this.nbt == null) {
			this.nbt = new NbtCompound();
        }
        return this.nbt;
    }

	@Override
	public void setNbt(NbtCompound nbt) {
		this.nbt = nbt;
	}
}