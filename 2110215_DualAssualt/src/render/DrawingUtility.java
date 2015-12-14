


package render;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

public class DrawingUtility {
	static BufferedImage getImage(String directory) {
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

	/* install image */
	protected static final BufferedImage titleBG = getImage("res/img/bgTitle.png");
	public static final BufferedImage playerImage = getImage("res/img/charingame2.png");
	public static BufferedImage playerProfile = getImage("res/img/profile1.jpg");
	public static BufferedImage bg = getImage("res/img/backgroundgrass.jpg");
	public static BufferedImage newGame = DrawingUtility.getImage("res/img/buttonNewGame.png");
	public static BufferedImage newGame2 = DrawingUtility.getImage("res/img/buttonNewGameMouseOn.png");
	public static BufferedImage setting = DrawingUtility.getImage("res/img/buttonSetting.png");
	public static BufferedImage quit=DrawingUtility.getImage("res/img/buttonQuit.png");public static BufferedImage statusBar = getImage("res/img/statusbar.png");

	public static BufferedImage resizeImage(BufferedImage originalImage, int type, int newWidth, int newHeight) {
		BufferedImage resizedImage = new BufferedImage(newWidth, newHeight, type);
		Graphics2D g = resizedImage.createGraphics();
		g.drawImage(originalImage, 0, 0, newWidth, newHeight, null);
		g.dispose();
		return resizedImage;
	}

	
}


