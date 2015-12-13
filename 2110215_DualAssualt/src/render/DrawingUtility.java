
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
	/*install image*/
	protected static final BufferedImage titleBG = getImage("res/img/bgTitle.png");
	public static final BufferedImage playerImage = getImage("res/img/charingame2.png");
	public static BufferedImage playerProfile = getImage("res/img/profile1.jpg");
	public static BufferedImage bg = getImage("res/img/backgroundgrass.jpg");
	
	public static BufferedImage resizeImage(BufferedImage originalImage, int type) {
		int newHeight = SettingScreen.screenHeight/6;
		int newWidht = (originalImage.getWidth()*SettingScreen.screenWidth)/1245;
		BufferedImage resizedImage = new BufferedImage(300, newHeight, type);
		Graphics2D g = resizedImage.createGraphics();
		g.drawImage(originalImage, 0, 0, 300, newHeight, null);
		g.dispose();
		return resizedImage;
	}
	
	public static BufferedImage resizeButton(BufferedImage originalImage, int type) {
		BufferedImage resizedImage = new BufferedImage(originalImage.getWidth(), originalImage.getWidth(), type);
		Graphics2D g = resizedImage.createGraphics();
		g.drawImage(originalImage, 0, 0, originalImage.getWidth()-180, originalImage.getHeight()-40, null);
		g.dispose();
		return resizedImage;
	}
	
}

