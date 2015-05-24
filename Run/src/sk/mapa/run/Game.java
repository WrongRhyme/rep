package sk.mapa.run;

import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;

import javax.swing.JFrame;

import sk.mapa.run.graphics.Screen;
import sk.mapa.run.input.Keyboard;

/**
 * Main project class, represents game itself.
 */
public class Game extends Canvas implements Runnable {

    private static final long serialVersionUID = 8391216654197197342L;

    private Thread thread;
    private JFrame frame;
    private boolean running = false;
    private Screen screen;
    private Keyboard key;
    private int xOffset;
    private int yOffset;

    /**
     * Represents rendered image of the game.
     */
    private BufferedImage image = new BufferedImage(Constants.WINDOW_WIDTH, Constants.WINDOW_HEIGHT,
	    BufferedImage.TYPE_INT_RGB);
    /**
     * Array of pixels displayed on the screen.
     */
    private int[] pixels = ((DataBufferInt) image.getRaster().getDataBuffer()).getData();

    public Game() {
	Dimension size = new Dimension(Constants.WINDOW_WIDTH * Constants.SCALE, Constants.WINDOW_HEIGHT
		* Constants.SCALE);
	setPreferredSize(size);

	frame = new JFrame(Constants.gameTitle);
	screen = new Screen(Constants.WINDOW_WIDTH, Constants.WINDOW_HEIGHT);
	key = new Keyboard();

	addKeyListener(key);
    }

    @Override
    public void run() {
	long lastTime = System.nanoTime();
	long timer = System.nanoTime();
	long now;
	long delta = 0;

	int updates = 0;
	int frames = 0;

	while (running) {
	    now = System.nanoTime();
	    delta += (now - lastTime);
	    lastTime = now;

	    if (delta >= Constants.FRAME_TIME) {
		update();
		updates++;
		delta -= Constants.FRAME_TIME;
	    }

	    render();
	    frames++;

	    if ((now - timer) > Constants.NS) {
		frame.setTitle(Constants.gameTitle + "  |  FPS: " + frames + ", Updates: " + updates);
		updates = 0;
		frames = 0;
		timer = now;
	    }
	}
	stop();
    }

    public synchronized void start() {
	thread = new Thread(this, Constants.MAIN_THREAD_NAME);
	thread.start();
	running = true;
    }

    public synchronized void stop() {
	try {
	    thread.join();
	} catch (InterruptedException e) {
	    e.printStackTrace();
	}
	running = false;
    }

    /**
     * Prepares and displays images on the screen.
     */
    public void render() {
	BufferStrategy bufferStrategy = getBufferStrategy();

	if (bufferStrategy == null) {
	    createBufferStrategy(3);
	    return;
	}

	Graphics graphics = bufferStrategy.getDrawGraphics();
	// ///////////////////////////////////////////////////
	screen.clear();
	screen.render(xOffset, yOffset);
	for (int i = 0; i < pixels.length; i++) {
	    pixels[i] = screen.pixels[i];// getPixel(i);
	    // System.out.println("Game: [" + i + "] = " + pixels[i]);

	}
	graphics.drawImage(image, 0, 0, this.getWidth(), this.getHeight(), null);
	// ///////////////////////////////////////////////////
	graphics.dispose();
	bufferStrategy.show();
    }

    /**
     * Updates scene. Restricted to run Constants.FPS (60) times per second.
     */
    public void update() {
	key.update();
	if (key.isUp()) {
	    yOffset++;
	}
	if (key.isDown()) {
	    yOffset--;
	}
	if (key.isLeft()) {
	    xOffset++;
	}
	if (key.isRight()) {
	    xOffset--;
	}

    }

    /**
     * Initialises main game window.
     * 
     * @param game - Game object for initialisation
     */
    private void initMainWindow(Game game) {
	game.frame.setResizable(true);
	game.frame.add(game);
	game.frame.pack();
	game.frame.setLocationRelativeTo(null);
	game.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	game.frame.setVisible(true);
    }

    public static void main(String[] args) {
	Game game = new Game();
	game.initMainWindow(game);
	game.start();
	game.requestFocus();
    }
}
