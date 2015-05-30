package sk.mapa.run.graphics.sprites;

import sk.mapa.run.Const;
import sk.mapa.run.graphics.SpriteSheet;

public final class Sky extends Sprite {

	private static Sky sky;

	private Sky(int size, int xPos, int yPos, SpriteSheet spriteSheet) {
		super(size, xPos, yPos, spriteSheet);
	}

	public static Sky getInstance() {
		if (sky == null) {
			sky = new Sky(Const.TILE_SIZE, 2, 0, SpriteSheet.getInstance(getPath()));
		}

		return sky;
	}

}
