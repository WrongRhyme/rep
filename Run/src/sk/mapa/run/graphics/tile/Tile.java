package sk.mapa.run.graphics.tile;

import sk.mapa.run.graphics.Sprite;

public class Tile {
    private int x;
    private int y;
    private Sprite sprite;

    /**
     * Parametric constructor.
     * 
     * @param x - horizontal position of the Sprite in the SpriteSheet
     * @param y - vertical position of the Sprite in the SpriteSheet
     * @param sprite - Sprite to be rendered as a Tile
     */
    public Tile(int x, int y, Sprite sprite) {
	this.x = x;
	this.y = y;
	this.sprite = sprite;
    }

    public void render() {

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
