package sk.mapa.run.graphics.tile;

import sk.mapa.run.Constants;
import sk.mapa.run.graphics.Sprite;
import sk.mapa.run.graphics.SpriteSheet;

public class Sky extends Sprite {

    private static Sky sky;

    private Sky(int size, int xPos, int yPos, SpriteSheet spriteSheet) {
	super(size, xPos, yPos, spriteSheet);
    }

    public static Sky getInstance() {
	if (sky == null) {
	    sky = new Sky(Constants.TILE_SIZE, 2, 0, SpriteSheet.getInstance(getPath(), Constants.SPRITE_SHEET_SIZE));
	}

	return sky;
    }

}
