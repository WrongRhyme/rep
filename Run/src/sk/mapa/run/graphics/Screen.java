package sk.mapa.run.graphics;

import java.util.Random;

import sk.mapa.run.Constants;
import sk.mapa.run.graphics.tile.Tile;

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
	tiles = new int[Constants.MAP_WIDTH * Constants.MAP_HEIGHT];

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
     * Renders the screen.
     */
    public void render(int xOffset, int yOffset) {
	for (int y = 0; y < height; y++) {
	    int yy = y + yOffset;
	    if (yy < 0 || yy >= height)
		continue;
	    for (int x = 0; x < width; x++) {
		int xx = x + xOffset;
		if (xx < 0 || xx >= width)
		    continue;
		// pixels[xx + yy * width] = Sky.getInstance().getPixels()[((x &
		// Constants.TILE_MASK) + (y & Constants.TILE_MASK)
		// * Constants.TILE_SIZE)];
		pixels[xx + yy * width] = Sprites.sky.getPixels()[((x & Constants.TILE_MASK) + (y & Constants.TILE_MASK)
			* Constants.TILE_SIZE)];
	    }
	}
    }

    /**
     * Renders Tile at specified position.
     * 
     * @param xPos - horizontal Tile position
     * @param yPos - vertical Tile position
     * @param tile - Tile to be rendered
     */
    public void renderTile(int xPos, int yPos, Tile tile) {
	int size = tile.getSprite().getSIZE();

	for (int y = 0; y < size; y++) {
	    for (int x = 0; x < size; x++) {
		pixels[x + y * width] = tile.getSprite().getPixels()[x + y * size];
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
}
