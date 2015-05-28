package sk.mapa.run.graphics.sprites;

import sk.mapa.run.Const;
import sk.mapa.run.graphics.SpriteSheet;

public final class Grass extends Sprite {

	private static Grass grass;

	private Grass(int size, int xPos, int yPos, SpriteSheet spriteSheet) {
		super(size, xPos, yPos, spriteSheet);
	}

	public static Grass getInstance() {
		if (grass == null) {
			grass = new Grass(Const.TILE_SIZE, 1, 0, SpriteSheet.getInstance(getPath(), Const.SPRITE_SHEET_SIZE));
		}

		return grass;
	}
}
