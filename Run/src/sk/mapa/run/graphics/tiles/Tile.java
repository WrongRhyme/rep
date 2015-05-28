package sk.mapa.run.graphics.tiles;

import sk.mapa.run.graphics.Screen;
import sk.mapa.run.graphics.sprites.Sprite;

public class Tile {
	private int x;
	private int y;
	private Sprite sprite;

	/**
	 * Parametric constructor.
	 * 
	 * @param sprite - Sprite to be rendered as a Tile
	 */
	public Tile(Sprite sprite) {
		this.sprite = sprite;
	}

	public void render(int x, int y, Screen screen) {
		screen.renderTile(x << 5, y << 5, this);
	}

	// G + S
	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public Sprite getSprite() {
		return sprite;
	}

	public void setSprite(Sprite sprite) {
		this.sprite = sprite;
	}
}
