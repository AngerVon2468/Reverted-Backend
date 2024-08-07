package wiiu.mavity.reverted_backend;

import net.fabricmc.api.ModInitializer;

import net.minecraft.SharedConstants;
import net.minecraft.item.Item;
import net.minecraft.registry.*;
import net.minecraft.util.Identifier;
import org.slf4j.*;

public class RevertedBackend implements ModInitializer {

	public static final String MOD_ID = "reverted_backend";

	public static final String NAME = "Reverted Backend";

    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {

		RevertedBackend.LOGGER.info(NAME + " has started up!");
		RevertedBackendDataComponentTypes.registerRevertedBackendDataComponentTypes();
		if (SharedConstants.isDevelopment) {
			TestItem testItem = Registry.register(Registries.ITEM, new Identifier(RevertedBackend.MOD_ID, "test_item"), new TestItem(new Item.Settings()));
		}
	}
}