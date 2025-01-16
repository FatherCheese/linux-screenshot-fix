package cookie.screenshot.extra.mixins;

import com.b100.utils.ImageUtils;
import cookie.screenshot.extra.utils.TransferableImage;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.util.helper.FileOpener;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.awt.*;

@Mixin(value = FileOpener.class, remap = false)
@Environment(EnvType.CLIENT)
public abstract class FileOpenerMixin {
	@Inject(method = "toClipboard", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/util/helper/FileOpener;run(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Z", ordinal = 2))
	private static void screenshot_linuxToClipboard(String path, CallbackInfoReturnable<Boolean> cir) {
		Image image = ImageUtils.loadExternalImage(path);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(new TransferableImage(image), null);
	}
}
