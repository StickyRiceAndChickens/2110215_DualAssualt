package logic;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;

import render.DrawingUtility;
import render.IRenderable;
import render.SettingScreen;

public class GameStatusBar implements IRenderable {
	private Player p1, p2;

	public GameStatusBar(Player p1, Player p2) {

		this.p1 = p1;
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
		g2d.fillRect(0, SettingScreen.screenHeight - (SettingScreen.screenHeight / 5), SettingScreen.screenWidth,
				(SettingScreen.screenHeight / 5));
		g2d.drawImage(DrawingUtility.resizeImage(DrawingUtility.statusBar, 2, SettingScreen.screenWidth, SettingScreen.screenHeight/5), null, 0, SettingScreen.screenHeight-SettingScreen.screenHeight/5);
		g2d.setColor(new Color(210, 210, 210));
		g2d.setFont(new Font("Tahoma", Font.BOLD, 30));
		g2d.drawString(p1.getName(), 5, SettingScreen.screenHeight - 10);
		g2d.drawImage(DrawingUtility.playerProfile, null, 5,
				(SettingScreen.screenHeight - (SettingScreen.screenHeight / 5)) + 30);
		Color lifeColor = new Color(68, 255, 0);
		if (p1.getLife() < 15) {
			lifeColor = new Color(255, 0, 0);
		} else if (p1.getLife() < 30) {
			lifeColor = new Color(255, 230, 0);
		}
		g2d.setColor(lifeColor);
		g2d.fillRect(120, SettingScreen.screenHeight - (SettingScreen.screenHeight / 5) + 40, p1.getLife() * 5, 30);
		g2d.setColor(Color.BLACK);
		g2d.setFont(new Font("Tahoma", Font.ITALIC, 30));
		Gun gun = (Gun) p1.getWeapon();
		g2d.drawString(gun.getStatus(), 145, SettingScreen.screenHeight - 35);
		g2d.drawString(Integer.toString(gun.getMagazine()) + "/" + Integer.toString(gun.getAmmo()), 145,
				SettingScreen.screenHeight - 10);
	}

	@Override
	public boolean isVisible() {
		// TODO Auto-generated method stub
		return true;
	}

}
