package sk.mapa.run.graphics.sprites;

import sk.mapa.run.Const;
import sk.mapa.run.graphics.SpriteSheet;

public final class Dirt extends Sprite {

	private static Dirt dirt;

	private Dirt(int size, int xPos, int yPos, SpriteSheet spriteSheet) {
		super(size, xPos, yPos, spriteSheet);
	}

	public static Dirt getInstance() {
		if (dirt == null) {
			dirt = new Dirt(Const.TILE_SIZE, 0, 0, SpriteSheet.getInstance(getPath()));
		}

		return dirt;
	}
}
