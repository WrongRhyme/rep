package sk.mapa.run.graphics.sprites;

public final class Sprites {

	public static final Sprite voidSprite = VoidSprite.getInstance();
	public static final Dirt dirt = Dirt.getInstance();
	public static final Grass grass = Grass.getInstance();
	public static final Sky sky = Sky.getInstance();
	public static final Start start = Start.getInstance();

	public static final PlayerSprite player0 = PlayerSprite.getInstance(0);
	public static final PlayerSprite player1 = PlayerSprite.getInstance(1);
	public static final PlayerSprite player2 = PlayerSprite.getInstance(2);
}
