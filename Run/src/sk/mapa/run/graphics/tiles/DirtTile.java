package sk.mapa.run.graphics.tiles;

import sk.mapa.run.graphics.sprites.Sprite;
import sk.mapa.run.graphics.sprites.Sprites;

public final class DirtTile extends Tile {

	private static DirtTile dirtTile;

	/**
	 * Parameric constructor.
	 * 
	 * @param sprite - {@link Sprite} to render for this tile
	 */
	private DirtTile(Sprite sprite) {
		super(sprite);
	}

	public static DirtTile getInstance() {
		if (dirtTile == null) {
			dirtTile = new DirtTile(Sprites.dirt);
		}

		return dirtTile;
	}

	// @Override
	// public void render(int x, int y, Screen screen) {
	// screen.renderTile(x << 5, y << 5, this);
	// }
}
