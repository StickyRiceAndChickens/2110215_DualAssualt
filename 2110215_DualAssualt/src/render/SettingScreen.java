
package render;

import java.awt.Graphics2D;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class SettingScreen extends JPanel{
	
	public static int screenWidth=1280;
	public static int screenHeight=600;
	
	public SettingScreen(int width, int height) {
		screenWidth = width;
		screenHeight = height;
	}
	
	public void draw(Graphics2D g2d) {
		
	}
	
}

