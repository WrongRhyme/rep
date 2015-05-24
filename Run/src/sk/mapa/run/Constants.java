package sk.mapa.run;

/**
 * Application-wide constants.
 */
public final class Constants {
    public static final int WINDOW_WIDTH = 300;
    public static final int WINDOW_HEIGHT = 168; // WINDOW_WIDTH / 16 * 9;
    public static final int SCALE = 3;
    public static String gameTitle = "Run";

    public static final String MAIN_THREAD_NAME = "MainThread";

    public static final int MAP_WIDTH = 512;
    public static final int MAP_HEIGHT = 16;
    public static final int TILE_SIZE = 32;
    public static final int TILE_MASK = 31;
    public static final int SPRITE_SHEET_SIZE = 128;

    public static final int COLOURS_COUNT = 0xFFFFFF;

    /**
     * Nanoseconds in 1 second.
     */
    public static final long NS = 1000000000;
    /**
     * Number of frames that we want to display per second.
     */
    public static final long FPS = 60;
    /**
     * Display time of one frame in nanoseconds.
     */
    public static final long FRAME_TIME = NS / FPS;

}
