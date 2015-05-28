package sk.mapa.run.graphics.tiles;

import sk.mapa.run.graphics.sprites.Sprite;
import sk.mapa.run.graphics.sprites.Sprites;

/**
 * Singleton representig grass tile.
 */
public final class GrassTile extends Tile {

	private static GrassTile grassTile;

	/**
	 * Parameric constructor.
	 * 
	 * @param sprite - {@link Sprite} to render for this tile
	 */
	private GrassTile(Sprite sprite) {
		super(sprite);
	}

	/**
	 * Gets the instance of grass tile.
	 * 
	 * @return {@link GrassTile} instance
	 */
	public static GrassTile getInstance() {
		if (grassTile == null) {
			grassTile = new GrassTile(Sprites.grass);
		}

		return grassTile;
	}
}
