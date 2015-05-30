package sk.mapa.run.graphics.level;

import sk.mapa.run.Const;
import sk.mapa.run.graphics.Screen;
import sk.mapa.run.graphics.tiles.Tile;
import sk.mapa.run.graphics.tiles.Tiles;

/**
 * Organizes the Tiles that need to be rendered.
 */
public class Level {

	protected int width;
	protected int height;
	protected int[] tiles;
	protected int[] pixels;

	public Level(int width, int height) {
		this.width = width;
		this.height = height;
		tiles = new int[width * height];
		generateLevel();
	}

	public Level(String path) {
		loadLevel(path);
		generateLevel();
	}

	protected void loadLevel(String path) {
	}

	protected void generateLevel() {
	}

	public void render(int xScroll, int yScroll, Screen screen) {
		screen.setOffset(xScroll, yScroll);

		int xStart = xScroll >> Const.SHIFT;
		int xEnd = (xScroll + screen.getWidth() + Const.TILE_SIZE) >> Const.SHIFT;
		int yStart = yScroll >> Const.SHIFT;
		int yEnd = (yScroll + screen.getHeight() + Const.TILE_SIZE) >> Const.SHIFT;

		for (int y = yStart; y < yEnd; y++) {
			for (int x = xStart; x < xEnd; x++) {
				// if (x < 0 || x >= width || y < 0 || y >= height)
				// break;
				getTile(x, y).render(x, y, screen);
				// getTile(x, y).render(x, y, screen);
			}
		}
	}

	private Tile getTile(int x, int y) {
		if (x < 0 || y < 0 || x >= width || y >= height) {
			return Tiles.voidTile;
		}

		switch (pixels[x + y * width]) {
			case (Const.DIRT_COLOUR):
				return Tiles.dirt;
			case (Const.GRASS_COLOUR):
				return Tiles.grass;
			case (Const.SKY_COLOUR):
				return Tiles.sky;
			case (Const.START_COLOUR):
				return Tiles.start;
			default:
				return Tiles.voidTile;
		}
	}
}
