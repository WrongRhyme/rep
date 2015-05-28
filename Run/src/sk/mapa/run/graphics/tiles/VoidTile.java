package sk.mapa.run.graphics.tiles;

import sk.mapa.run.graphics.sprites.Sprite;
import sk.mapa.run.graphics.sprites.Sprites;

public final class VoidTile extends Tile {

	private static VoidTile voidTile;

	private VoidTile(Sprite sprite) {
		super(sprite);
	}

	public static VoidTile getInstance() {
		if (voidTile == null) {
			voidTile = new VoidTile(Sprites.voidSprite);
		}

		return voidTile;
	}

}
