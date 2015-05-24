package sk.mapa.run.graphics.tile;

import sk.mapa.run.Constants;
import sk.mapa.run.graphics.Sprite;
import sk.mapa.run.graphics.SpriteSheet;

public class Grass extends Sprite {

    private static Grass grass;

    private Grass(int size, int xPos, int yPos, SpriteSheet spriteSheet) {
	super(size, xPos, yPos, spriteSheet);
    }

    public static Grass getInstance() {
	if (grass == null) {
	    grass = new Grass(Constants.TILE_SIZE, 1, 0,
		    SpriteSheet.getInstance(getPath(), Constants.SPRITE_SHEET_SIZE));
	}

	return grass;
    }
}
