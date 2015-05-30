package sk.mapa.run.graphics.sprites;

import sk.mapa.run.Const;
import sk.mapa.run.graphics.SpriteSheet;

public class PlayerSprite extends Sprite {

	private static PlayerSprite player0;
	private static PlayerSprite player1;
	private static PlayerSprite player2;

	private PlayerSprite(int size, int xPos, int yPos, SpriteSheet spriteSheet) {
		super(size, xPos, yPos, spriteSheet);
	}

	public static PlayerSprite getInstance(int phase) {
		switch (phase) {
			case (0):
				if (player0 == null) {
					player0 = new PlayerSprite(Const.PLAYER_SIZE, 0, 1, SpriteSheet.getInstance(getPath()));
				}
				return player0;

			case (1):
				if (player1 == null) {
					player1 = new PlayerSprite(Const.PLAYER_SIZE, 0, 2, SpriteSheet.getInstance(getPath()));
				}
				return player1;

			case (2):
				if (player2 == null) {
					player2 = new PlayerSprite(Const.PLAYER_SIZE, 0, 3, SpriteSheet.getInstance(getPath()));
				}
				return player2;

			default:
				throw new IllegalArgumentException(
						"Incorrect Player Sprite phase. Correct values are {0, 1, 2}. Your value: " + phase);

		}
	}
}
