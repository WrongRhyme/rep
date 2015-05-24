package sk.mapa.run.graphics.tile;

import sk.mapa.run.Constants;
import sk.mapa.run.graphics.Sprite;
import sk.mapa.run.graphics.SpriteSheet;

public class Dirt extends Sprite {

    private static Dirt dirt;

    private Dirt(int size, int xPos, int yPos, SpriteSheet spriteSheet) {
	super(size, xPos, yPos, spriteSheet);
    }

    public static Dirt getInstance() {
	if (dirt == null) {
	    dirt = new Dirt(Constants.TILE_SIZE, 0, 0, SpriteSheet.getInstance(getPath(), Constants.SPRITE_SHEET_SIZE));
	}

	return dirt;
    }
}
