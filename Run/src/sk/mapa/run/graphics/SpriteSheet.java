package sk.mapa.run.graphics;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

/**
 * Singleton class representing SpriteSheet to get images from.
 */
public class SpriteSheet {

	/**
	 * Path to image representing SpriteSheet.
	 */
	private String path;

	/**
	 * SpriteSheet pixels.
	 */
	private int[] pixels;

	/**
	 * Only instance of SpriteSheet.
	 */
	private static SpriteSheet spriteSheet;

	/**
	 * Private constructor.
	 */
	private SpriteSheet(String path) {
		this.path = path;
		load();
	}

	private void load() {
		BufferedImage image;
		try {
			image = ImageIO.read(SpriteSheet.class.getResource(path));
			int width = image.getWidth();
			int height = image.getHeight();
			pixels = new int[width * height];
			image.getRGB(0, 0, width, height, pixels, 0, width);
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Returns the only instance of SpriteSheet.
	 * 
	 * @param path - path to image representing SpriteSheet
	 * @return instance of SpriteSheet
	 */
	public static SpriteSheet getInstance(String path) {
		if (spriteSheet == null) {
			spriteSheet = new SpriteSheet(path);
			return spriteSheet;
		}

		return spriteSheet;
	}

	// G + S
	public int[] getPixels() {
		return pixels;
	}

	public void setPixels(int[] pixels) {
		this.pixels = pixels;
	}

	public int getPixel(int index) {
		return pixels[index];
	}
}
