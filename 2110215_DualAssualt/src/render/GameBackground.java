package render;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;


public class GameBackground implements IRenderable{

	private BufferedImage bgImage = null;
	private int currentX = 0;
	private int imageWidth;
	
	public GameBackground(){
		bgImage = DrawingUtility.resizeImage(DrawingUtility.bg, 2, 20, 20);
		if(bgImage != null){
			imageWidth = bgImage.getWidth();
		}else{
			imageWidth = 0;
		}
	}
	
	public void updateBackground(){
		currentX++;
		if(currentX >= imageWidth){
			currentX = 0;
		}
	}
	
	@Override
	public boolean isVisible() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public int getZ() {
		// TODO Auto-generated method stub
		return Integer.MIN_VALUE;
	}

	

	@Override
	public void draw(Graphics2D g2d) {
		// TODO Auto-generated method stub
		if(bgImage == null) return;
		int currentDrawingX = 0;
		int currentDrawingY = 0;
		
//		
		while(currentDrawingY < SettingScreen.screenHeight){
			g2d.drawImage(bgImage.getSubimage(currentX, 0, imageWidth-currentX, bgImage.getHeight()),
					null, currentDrawingX, currentDrawingY);
			currentDrawingY += bgImage.getHeight();
		}
		currentDrawingX += imageWidth - currentX;
		currentDrawingY = 0;
		
		while(currentDrawingX < SettingScreen.screenWidth){
			while(currentDrawingY < SettingScreen.screenHeight){
				g2d.drawImage(bgImage, null, currentDrawingX, currentDrawingY);
				currentDrawingY += bgImage.getHeight();
			}
			currentDrawingX += imageWidth;
			currentDrawingY = 0;
		
		
//		
		}
	}

	
}

