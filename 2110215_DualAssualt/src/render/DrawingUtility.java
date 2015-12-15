
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
	public static BufferedImage enemy1 = getImage("res/img/bot1.png");
	public static BufferedImage enemy2 = getImage("res/img/bot2.png");
	public static BufferedImage playerProfile = getImage("res/img/profile1.jpg");
	public static BufferedImage bg = getImage("res/img/bgGrass.jpg");
	public static BufferedImage newGame = DrawingUtility.getImage("res/img/buttonNewGame.png");
	public static BufferedImage newGame2 = DrawingUtility.getImage("res/img/buttonNewGameMouseOn.png");
	public static BufferedImage setting = DrawingUtility.getImage("res/img/buttonSetting.png");
	public static BufferedImage setting2 = DrawingUtility.getImage("res/img/buttonSettingMouseOn.png");
	public static BufferedImage quit = DrawingUtility.getImage("res/img/buttonQuit.png");
	public static BufferedImage quit2 = DrawingUtility.getImage("res/img/buttonQuitMouseOn.png");
	public static BufferedImage statusBar = getImage("res/img/statusBar.png");
	public static BufferedImage iconRifle = getImage("res/img/iconRifle.png");
	public static BufferedImage iconShotgun = getImage("res/img/iconShotgun.png");
	public static BufferedImage bgGunStatus = getImage("res/img/bgGunStatus.jpg");
	public static BufferedImage bgChar = getImage("res/img/bgChar.png");
	public static BufferedImage bgPlayerMenu = getImage("res/img/bgSettingScreen.jpg");
	public static BufferedImage bgSettingScreen = getImage("res/img/bgSettingScreen.jpg");

	public static BufferedImage character[] = { getImage("res/img/char1.png"), getImage("res/img/char2.png"),
			getImage("res/img/char3.png"), getImage("res/img/char4.png"), getImage("res/img/char5.png") };

	public static BufferedImage resizeImage(BufferedImage originalImage, int type, int newWidth, int newHeight) {
		BufferedImage resizedImage = new BufferedImage(newWidth, newHeight, type);
		Graphics2D g = resizedImage.createGraphics();
		g.drawImage(originalImage, 0, 0, newWidth, newHeight, null);
		g.dispose();
		return resizedImage;
	}

}
