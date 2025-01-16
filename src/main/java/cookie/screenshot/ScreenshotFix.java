package cookie.screenshot;

import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ScreenshotFix implements ModInitializer {
    public static final String MOD_ID = "screenshot";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);
    @Override
    public void onInitialize() {
        LOGGER.info("Screenshot Fix initialized.");
    }
}
