package render;

import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;



public class DrawingUtility {
	private static BufferedImage getImage(String directory) {
		/* try to load image */
		ClassLoader loader = DrawingUtility.class.getClassLoader();
		BufferedImage image;
		try {

			image = ImageIO.read(loader.getResource(directory));
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Fail load image from " + directory);
			image = null;
		}
		return image;

	}
	/*install image*/
	protected static final BufferedImage bg = getImage("res/img/bg.jpg");
}
