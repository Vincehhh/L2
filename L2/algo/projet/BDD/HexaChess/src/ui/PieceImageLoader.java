package src.ui;

import java.awt.Image;
import java.net.URI;
import java.util.HashMap;
import java.util.Map;
import javax.imageio.ImageIO;

class PieceImageLoader {
	private static final String BASE_URL =
		"https://images.chesscomfiles.com/chess-themes/pieces/classic/300/";
	private static final Map<String, Image> images = new HashMap<>();
	private static void loadImage(String key) {
		try {
			images.put(key, ImageIO.read(URI.create(BASE_URL + key + ".png").toURL()));
		} catch (Exception exception) {
			System.err.println("Exception: " + exception.getMessage());
		}
	}
	static void loadImages() {
		for (String c : new String[] {"w", "b"})
			for (String t : new String[] {"p", "r", "n", "b", "q", "k"}) loadImage(c + t);
	}
	static Image get(String key) {
		return images.get(key);
	}
}