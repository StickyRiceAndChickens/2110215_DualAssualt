package logic;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import render.DrawingUtility;
import render.GameManager;
import render.IRenderable;
import render.SettingScreen;

public class GameStatusBar implements IRenderable {
	
	private Player p1, p2;
	

	public GameStatusBar(Player p1, Player p2) {

		this.p1 = p1;
		this.p2 = p2;
		
	}

	public void setP1(Player p1) {
		this.p1 = p1;
	}

	public void setP2(Player p2) {
		this.p2 = p2;
	}

	@Override
	public int getZ() {
		// TODO Auto-generated method stub
		return Integer.MAX_VALUE;
	}

	@Override
	public void draw(Graphics2D g2d) {
		// TODO Auto-generated method stub
		g2d.setColor(new Color(67, 73, 246));
//		g2d.fillRect(0, SettingScreen.screenHeight - (SettingScreen.screenHeight / 5), SettingScreen.screenWidth,
//				(SettingScreen.screenHeight / 5));
		g2d.drawImage(DrawingUtility.resizeImage(DrawingUtility.statusBar, 2, SettingScreen.screenWidth, SettingScreen.screenHeight/5), null, 0, SettingScreen.screenHeight-SettingScreen.screenHeight/5);
		g2d.setColor(new Color(210, 210, 210));
		g2d.setFont(new Font("Tahoma", Font.BOLD, 30));
		g2d.drawString(p1.getName(), 10, SettingScreen.screenHeight - 10);
		g2d.drawString(p2.getName(), SettingScreen.screenWidth-110, SettingScreen.screenHeight - 10);
		
		g2d.drawImage(DrawingUtility.resizeImage(DrawingUtility.playerProfile[GameManager.playerMenuScreen.getP1Select()],2,SettingScreen.screenHeight / 7,SettingScreen.screenHeight / 7), null, 10,
				(SettingScreen.screenHeight - (SettingScreen.screenHeight / 5))+6 );
		
		g2d.drawImage(DrawingUtility.resizeImage(DrawingUtility.playerProfile[GameManager.playerMenuScreen.getP2Select()], 2,SettingScreen.screenHeight / 7,SettingScreen.screenHeight / 7), null, SettingScreen.screenWidth-110,
				(SettingScreen.screenHeight - (SettingScreen.screenHeight / 5))+6 );
		
		Color lifeColor1 = new Color(68, 255, 0);
		if (p1.getLife() < 15) {
			lifeColor1 = new Color(255, 0, 0);
		} else if (p1.getLife() < 30) {
			lifeColor1 = new Color(255, 230, 0);
		}
		g2d.setColor(lifeColor1);
		g2d.fillRect(120, SettingScreen.screenHeight - (SettingScreen.screenHeight / 5) + 40, p1.getLife() * 5, 30);
		
		
		Color lifeColor2 = new Color(68, 255, 0);
		if (p2.getLife() < 15) {
			lifeColor2 = new Color(255, 0, 0);
		} else if (p2.getLife() < 30) {
			lifeColor2 = new Color(255, 230, 0);
		}
		g2d.setColor(lifeColor2);
		g2d.fillRect(SettingScreen.screenWidth-370, SettingScreen.screenHeight - (SettingScreen.screenHeight / 5) + 40, p2.getLife() * 5, 30);
		g2d.setColor(Color.BLACK);
		g2d.setFont(new Font("Tahoma", Font.ITALIC, 30));
		
		g2d.drawImage(DrawingUtility.resizeImage(DrawingUtility.bgGunStatus, 2, 190, 60), null, 130, SettingScreen.screenHeight-65);
		g2d.drawImage(DrawingUtility.resizeImage(DrawingUtility.bgGunStatus, 2, 190, 60), null, SettingScreen.screenWidth-320, SettingScreen.screenHeight-65);
		
		Gun gun1 = (Gun) p1.getWeapon();
		if (gun1.getGunType() == 0) g2d.drawImage(DrawingUtility.resizeImage(DrawingUtility.iconShotgun, 2, 50, 50), null, 135, SettingScreen.screenHeight-60);
		else g2d.drawImage(DrawingUtility.resizeImage(DrawingUtility.iconRifle, 2, 50, 50), null, 135, SettingScreen.screenHeight-60);
		g2d.drawString(gun1.getStatus(), 200, SettingScreen.screenHeight - 40);
		g2d.drawString(Integer.toString(gun1.getMagazine()) + "/" + Integer.toString(gun1.getAmmo()), 200,
				SettingScreen.screenHeight - 10);
		
		Gun gun2 = (Gun) p2.getWeapon();
		if (gun2.getGunType() == 0) g2d.drawImage(DrawingUtility.resizeImage(DrawingUtility.iconShotgun, 2, 50, 50), null, SettingScreen.screenWidth-195, SettingScreen.screenHeight-60);
		else g2d.drawImage(DrawingUtility.resizeImage(DrawingUtility.iconRifle, 2, 50, 50), null, SettingScreen.screenWidth-195, SettingScreen.screenHeight-60);
		g2d.drawString(gun2.getStatus(), SettingScreen.screenWidth-310, SettingScreen.screenHeight - 40);
		g2d.drawString(Integer.toString(gun2.getMagazine()) + "/" + Integer.toString(gun2.getAmmo()), SettingScreen.screenWidth-310,
				SettingScreen.screenHeight - 10);
		g2d.setColor(Color.pink);
		g2d.setFont(new Font("Tahoma", Font.ITALIC+Font.BOLD, 50));
		g2d.drawString("SCORE : "+GameLogic.map.getScore(),SettingScreen.screenWidth/3,SettingScreen.screenHeight-10);
		
	}

	@Override
	public boolean isVisible() {
		// TODO Auto-generated method stub
		return true;
	}

}
