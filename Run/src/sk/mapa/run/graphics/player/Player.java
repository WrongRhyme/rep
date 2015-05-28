package sk.mapa.run.graphics.player;

import sk.mapa.run.Const;
import sk.mapa.run.graphics.Screen;
import sk.mapa.run.graphics.sprites.PlayerSprite;
import sk.mapa.run.graphics.sprites.Sprite;
import sk.mapa.run.graphics.sprites.Sprites;
import sk.mapa.run.input.Keyboard;

public class Player {
	private int xPos;
	private int yPos;
	private Sprite sprite;
	private Keyboard input;
	private int tick = 0;
	private final int ticksPerPhase = (int) Const.FPS / Const.PLAYER_ANIM_PHASES / Const.PLAYER_ANIM_PHASES_RATIO;
	private final int phase = (int) Const.FPS / Const.PLAYER_ANIM_PHASES_RATIO;

	public Player(Keyboard key) {
		this.sprite = Sprites.player0;
		this.input = key;
	}

	public void update() {
		tick++;
		if (tick >= 10000) {
			tick = 0;
		}

	}

	public void render(Screen screen) {

		if (tick % phase > 0) {
			this.sprite = PlayerSprite.getInstance(0);
		}
		if (tick % phase > ticksPerPhase) {
			this.sprite = PlayerSprite.getInstance(1);
		}
		if (tick % phase > 2 * ticksPerPhase) {
			this.sprite = PlayerSprite.getInstance(2);
		}

		screen.renderPlayer(100, 100, sprite);
	}
}
