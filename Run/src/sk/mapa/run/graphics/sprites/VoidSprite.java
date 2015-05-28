package sk.mapa.run.graphics.sprites;

import sk.mapa.run.Const;

public final class VoidSprite extends Sprite {

	private static VoidSprite voidSprite;

	protected VoidSprite(int size, int colour) {
		super(size, colour);
	}

	public static VoidSprite getInstance() {
		if (voidSprite == null) {
			voidSprite = new VoidSprite(Const.TILE_SIZE, Const.VOID_TILE_COLOUR);
		}

		return voidSprite;
	}
}
