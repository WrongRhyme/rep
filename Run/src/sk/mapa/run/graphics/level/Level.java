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

	public Level(int width, int height) {
		this.width = width;
		this.height = height;
		tiles = new int[width * height];
		generateLevel();
	}

	protected void generateLevel() {
	}

	public void render(int xScroll, int yScroll, Screen screen) {
		screen.setOffset(xScroll, yScroll);

		int xStart = xScroll >> Const.SHIFT;
		int xEnd = (xScroll + screen.getWidth() + 32) >> Const.SHIFT;
		int yStart = yScroll >> Const.SHIFT;
		int yEnd = (yScroll + screen.getHeight() + 32) >> Const.SHIFT;

		for (int y = yStart; y < yEnd; y++) {
			for (int x = xStart; x < xEnd; x++) {
				getTile(x, y).render(x, y, screen);
			}
		}
	}

	private Tile getTile(int x, int y) {
		if (x < 0 || y < 0 || x >= width || y >= height) {
			return Tiles.voidTile;
		}
		if (tiles[x + y * width] == 0)
			return Tiles.dirt;
		else
			return Tiles.voidTile;

	}
}
