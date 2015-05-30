package sk.mapa.run.graphics.level;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Level1 extends Level {

	public Level1(String path) {
		super(path);
		loadLevel(path);
	}

	@Override
	protected void loadLevel(String path) {
		try {
			BufferedImage image = ImageIO.read(Level1.class.getResource(path));
			width = image.getWidth();
			height = image.getHeight();
			pixels = new int[width * height];
			image.getRGB(0, 0, width, height, pixels, 0, width);

		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
}
