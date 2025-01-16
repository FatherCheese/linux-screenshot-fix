package cookie.screenshot.extra.utils;

import com.b100.utils.Utils;
import org.jetbrains.annotations.NotNull;

import java.awt.*;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;

public class TransferableImage implements Transferable {
	private final Image image;

	public TransferableImage(Image image) {
		this.image = Utils.requireNonNull(image);
	}

	@Override
	public DataFlavor[] getTransferDataFlavors() {
		return new DataFlavor[]{DataFlavor.imageFlavor};
	}

	@Override
	public boolean isDataFlavorSupported(DataFlavor flavor) {
		return flavor == DataFlavor.imageFlavor;
	}

	@Override
	public @NotNull Object getTransferData(DataFlavor flavor) throws UnsupportedFlavorException {
		if (flavor == DataFlavor.imageFlavor) {
			return this.image;
		} else {
			throw new UnsupportedFlavorException(flavor);
		}
	}
}
