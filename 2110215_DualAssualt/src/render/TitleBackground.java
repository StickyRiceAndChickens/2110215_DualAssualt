package render;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

public class TitleBackground implements IRenderable{
	
	private BufferedImage titleBG = null;
	public static int imageWidth;
	public static int imageHeight;
	
	public TitleBackground(){
		this.titleBG = DrawingUtility.resizeImage(DrawingUtility.titleBG, 1, SettingScreen.screenWidth-300, SettingScreen.screenHeight);
	}
	
//	public static BufferedImage resizeImage(BufferedImage originalImage, int type) {
//		BufferedImage resizedImage = new BufferedImage(SettingScreen.screenWidth, SettingScreen.screenHeight, type);
//		Graphics2D g = resizedImage.createGraphics();
//		g.drawImage(originalImage, 0, 0, SettingScreen.screenWidth-300, SettingScreen.screenHeight, null);
//		g.dispose();
//		return resizedImage;
//	}
	
	
	public void draw(Graphics2D g2d) {
		g2d.drawImage(titleBG, null, 300, 0);
	}

	@Override
	public int getZ() {
		// TODO Auto-generated method stub
		return Integer.MIN_VALUE;
	}

	@Override
	public boolean isVisible() {
		// TODO Auto-generated method stub
		return true;
	}

}
