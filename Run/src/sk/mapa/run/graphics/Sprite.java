package sk.mapa.run.graphics;

import sk.mapa.run.Constants;

/**
 * Root class for game Sprites.
 */
public abstract class Sprite {
	/**
	 * Path to SpriteSheet file containing Sprite.
	 */
	private static String path = "/textures/spritesheet.bmp";

	/**
	 * Sprite size (width and height) in pixels.
	 */
	private int SIZE;

	/**
	 * X position in pixels of the upper left corner of the sprite in SpriteSheet.
	 */
	private int x;

	/**
	 * Y position in pixels of the upper left corner of the sprite in the SpriteSheet.
	 */
	private int y;

	/**
	 * Represents each pixel of Sprite.
	 */
	private int[] pixels;

	/**
	 * SpriteSheet this Sprite is read from.
	 */
	private SpriteSheet spriteSheet;

	/**
	 * Parametric constructor.
	 * 
	 * @param size - width and height of the Sprite
	 * @param xPos - x position of the Sprite tile in {@link SpriteSheet} (0-based)
	 * @param yPos - y position of the Sprite tile in SpriteSheet (0-based)
	 * @param spriteSheet - SpriteSheet to read data from
	 */
	protected Sprite(int size, int xPos, int yPos, SpriteSheet spriteSheet) {
		SIZE = size;
		x = xPos * SIZE;
		y = yPos * SIZE;
		this.spriteSheet = spriteSheet;
		pixels = new int[SIZE * SIZE];

		load();
	}

	private void load() {
		for (int y = 0; y < SIZE; y++) {
			for (int x = 0; x < SIZE; x++) {
				pixels[x + y * SIZE] = spriteSheet.getPixel((this.x + x) + (this.y + y) * Constants.SPRITE_SHEET_SIZE);
			}
		}
	}

	// G + S

	public static String getPath() {
		return path;
	}

	public static void setPath(String path) {
		Sprite.path = path;
	}

	public int getSIZE() {
		return SIZE;
	}

	public void setSIZE(int sIZE) {
		SIZE = sIZE;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int[] getPixels() {
		return pixels;
	}

	public void setPixels(int[] pixels) {
		this.pixels = pixels;
	}

	public SpriteSheet getSpriteSheet() {
		return spriteSheet;
	}

	public void setSpriteSheet(SpriteSheet spriteSheet) {
		this.spriteSheet = spriteSheet;
	}
}
