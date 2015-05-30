package sk.mapa.run.graphics.tiles;

import sk.mapa.run.graphics.sprites.Sprite;
import sk.mapa.run.graphics.sprites.Sprites;

public class StartTile extends Tile {

	private static StartTile startTile;

	private StartTile(Sprite sprite) {
		super(sprite);
	}

	public static StartTile getInstance() {
		if (startTile == null) {
			startTile = new StartTile(Sprites.start);
		}

		return startTile;
	}
}
