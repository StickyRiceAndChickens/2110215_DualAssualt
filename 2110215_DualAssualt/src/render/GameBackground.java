package render;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import lib.ConfigurableOption;
import lib.IRenderableObject;



public class GameBackground implements IRenderableObject{

	private BufferedImage bgImage = null;
	private int currentX = 0;
	private int imageWidth;
	
	public GameBackground(){
		bgImage = DrawingUtility.bg;
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
	public void render(Graphics2D g2) {
		// TODO Auto-generated method stub
		if(bgImage == null) return;
		int currentDrawingX = 0;
		int currentDrawingY = 0;
		
		while(currentDrawingY < ConfigurableOption.screenHeight){
			g2.drawImage(bgImage.getSubimage(currentX, 0, imageWidth-currentX, bgImage.getHeight()),
					null, currentDrawingX, currentDrawingY);
			currentDrawingY += bgImage.getHeight();
		}
		currentDrawingX += imageWidth - currentX;
		currentDrawingY = 0;
		
		while(currentDrawingX < ConfigurableOption.screenWidth){
			while(currentDrawingY < ConfigurableOption.screenHeight){
				g2.drawImage(bgImage, null, currentDrawingX, currentDrawingY);
				currentDrawingY += bgImage.getHeight();
			}
			currentDrawingX += imageWidth;
			currentDrawingY = 0;
		}
	}

	
}
