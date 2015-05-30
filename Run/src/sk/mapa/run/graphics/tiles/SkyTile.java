package sk.mapa.run.graphics.tiles;

import sk.mapa.run.graphics.sprites.Sprite;
import sk.mapa.run.graphics.sprites.Sprites;

public class SkyTile extends Tile {

	private static SkyTile skyTile;

	private SkyTile(Sprite sprite) {
		super(sprite);
	}

	public static SkyTile getIstance() {
		if (skyTile == null) {
			skyTile = new SkyTile(Sprites.sky);
		}

		return skyTile;
	}

}
