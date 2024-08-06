package wiiu.mavity.reverted_backend;

import net.fabricmc.api.ModInitializer;

import org.slf4j.*;

public class RevertedBackend implements ModInitializer {

	public static final String MOD_ID = "reverted_backend";

	public static final String NAME = "Reverted Backend";

    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {

		RevertedBackend.LOGGER.info(NAME + " has started up!");
	}
}