package sk.mapa.run.graphics.sprites;

import sk.mapa.run.Const;
import sk.mapa.run.graphics.SpriteSheet;

public class Start extends Sprite {

	private static Start start;

	private Start(int size, int xPos, int yPos, SpriteSheet spriteSheet) {
		super(size, xPos, yPos, spriteSheet);
	}

	public static Start getInstance() {
		if (start == null) {
			start = new Start(Const.TILE_SIZE, 3, 0, SpriteSheet.getInstance(getPath()));
		}
		return start;

	}
}
