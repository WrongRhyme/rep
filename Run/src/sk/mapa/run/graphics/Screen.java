package sk.mapa.run.graphics;

import java.util.Random;

import sk.mapa.run.Const;
import sk.mapa.run.graphics.sprites.Sprite;
import sk.mapa.run.graphics.tiles.Tile;

/**
 * Represents the contents rendered and displayed in the game window.
 *
 */
public class Screen {

	/**
	 * Visible screen width. Should be the same as window width.
	 */
	private int width;

	/**
	 * Visible screen height. Should be the same as window height.
	 */
	private int height;

	/**
     * 
     */
	private Random rnd = new Random();

	/**
	 * Visible contents of the screen.
	 */
	public int[] pixels;

	/**
	 * Tiles of the game.
	 */
	private int[] tiles;

	private int xOffset;
	private int yOffset;

	/**
	 * Parameric constructor. Sets pixels and tiles arrays.
	 * 
	 * @param width - visible screen width
	 * @param height - visible screen height
	 */
	public Screen(int width, int height) {
		this.width = width;
		this.height = height;

		pixels = new int[width * height];
		tiles = new int[Const.MAP_WIDTH * Const.MAP_HEIGHT];

	}

	/**
	 * Clears the screen. Paints the screen with black colour.
	 */
	public void clear() {
		for (int i = 0; i < pixels.length; i++) {
			pixels[i] = 0;
		}
	}

	/**
	 * Renders Tile at specified position.
	 * 
	 * @param xPos - horizontal Tile position (in pixels)
	 * @param yPos - vertical Tile position (in pixels)
	 * @param tile - Tile to be rendered
	 */
	public void renderTile(int xPos, int yPos, Tile tile) {
		int xAbs;
		int yAbs;
		int tileSize = tile.getSprite().getSIZE();

		xPos -= xOffset;
		yPos -= yOffset;

		for (int y = 0; y < tileSize; y++) {
			yAbs = y + yPos;
			for (int x = 0; x < tileSize; x++) {
				xAbs = x + xPos;
				if (xAbs < -tileSize || xAbs >= width || yAbs < 0 || yAbs >= height) {
					break;
				}

				if (xAbs < 0) {
					xAbs = 0;
				}

				pixels[xAbs + yAbs * width] = tile.getSprite().getPixels()[x + y * tileSize];
			}
		}

	}

	public void renderPlayer(int xPos, int yPos, Sprite sprite) {
		for (int y = 0; y < Const.PLAYER_SIZE; y++) {
			for (int x = 0; x < Const.PLAYER_SIZE; x++) {
				int colour = sprite.getPixels()[x + y * Const.PLAYER_SIZE];
				if (colour != 0xFFFF00DC) {
					pixels[xPos + x + (yPos + y) * width] = colour;
				}

			}
		}
	}

	// G + S
	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public Random getRnd() {
		return rnd;
	}

	public void setRnd(Random rnd) {
		this.rnd = rnd;
	}

	public int[] getPixels() {
		return pixels;
	}

	public void setPixels(int[] pixels) {
		this.pixels = pixels;
	}

	public void setPixel(int position, int value) {
		pixels[position] = value;
	}

	public int getPixel(int position) {
		return pixels[position];
	}

	public int[] getTiles() {
		return tiles;
	}

	public void setTiles(int[] tiles) {
		this.tiles = tiles;
	}

	public void setOffset(int xOffset, int yOffset) {
		this.xOffset = xOffset;
		this.yOffset = yOffset;
	}
}
