package wiiu.mavity.reverted_backend;

import net.minecraft.component.ComponentType;
import net.minecraft.component.type.NbtComponent;
import net.minecraft.registry.*;

import org.jetbrains.annotations.NotNull;

import java.util.function.UnaryOperator;

public class RevertedBackendDataComponentTypes {

    public static final ComponentType<NbtComponent> NBT = register("nbt", (builder) -> builder.codec(NbtComponent.CODEC));

    private static <T> ComponentType<T> register(String id, @NotNull UnaryOperator<ComponentType.Builder<T>> builderOperator) {
        return Registry.register(Registries.DATA_COMPONENT_TYPE, id, builderOperator.apply(ComponentType.builder()).build());
    }

    public static void registerRevertedBackendDataComponentTypes() {}
}