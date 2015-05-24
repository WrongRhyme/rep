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
     * Size (in pixels) of image representing SpriteSheet.
     */
    private final int SIZE;

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
    private SpriteSheet(String path, int size) {
	this.path = path;
	SIZE = size;
	pixels = new int[SIZE * SIZE];

	load();
    }

    private void load() {
	BufferedImage image;
	try {
	    // image = ImageIO.read(new File(path));
	    image = ImageIO.read(SpriteSheet.class.getResource(path));
	    int width = image.getWidth();
	    int height = image.getHeight();
	    image.getRGB(0, 0, width, height, pixels, 0, width);

	} catch (IOException e) {
	    e.printStackTrace();
	}
    }

    /**
     * Returns the only instance of SpriteSheet.
     * 
     * @param path
     *            - path to image representing SpriteSheet
     * @param size
     *            - size of SpriteSheet (it is a square)
     * @return instance of SpriteSheet
     */
    public static SpriteSheet getInstance(String path, int size) {
	if (spriteSheet == null) {
	    spriteSheet = new SpriteSheet(path, size);
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
