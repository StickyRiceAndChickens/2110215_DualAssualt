package logic;

import java.awt.image.BufferedImage;
import java.util.Set;

import render.DrawingUtility;
import render.RenderableHolder;
import render.SettingScreen;

public class Level {
	private Enemy e1;
	private Gun gun1;
	private int enemyCount = 0;
	private int x[] = {200,220,220,220,400,800,800,800,1100,1100,1100,80};
	private int y[] = {40,200,230,500,40,500,40,200,500,40,200,400,40};
	private BufferedImage imageChar[] = { DrawingUtility.enemy1, DrawingUtility.enemy1, DrawingUtility.enemy1,
			DrawingUtility.enemy1, DrawingUtility.enemy1, DrawingUtility.enemy1, DrawingUtility.enemy2,
			DrawingUtility.enemy2, DrawingUtility.enemy2, DrawingUtility.enemy2, DrawingUtility.enemy2,
			DrawingUtility.enemy3 };
	private MapObject wall;

	public Level() {
		while (enemyCount < 12) {
			e1 = new Enemy(30, x[enemyCount], y[enemyCount], 70, 40, 180, null, 3 + enemyCount, imageChar[enemyCount]);
			gun1 = new Gun(x[enemyCount], y[enemyCount], 0, e1, 3);
			e1.setWeapon(gun1);
			RenderableHolder.getInstance().add(e1);
			GameLogic.map.addEntity(e1);
			GameLogic.map.addEntity(gun1);
			enemyCount++;
		}
		
		wall = new MapObject(70, 300, 10, 500);
		RenderableHolder.getInstance().add(wall);
		GameLogic.map.addEntity(wall);
		
		wall = new MapObject(SettingScreen.screenWidth/2, 50, 1120, 10);
		RenderableHolder.getInstance().add(wall);
		GameLogic.map.addEntity(wall);
		
		wall = new MapObject(1200, 230, 10, 380);
		RenderableHolder.getInstance().add(wall);
		GameLogic.map.addEntity(wall);
		
		wall = new MapObject(500, 550, 850, 10);
		RenderableHolder.getInstance().add(wall);
		GameLogic.map.addEntity(wall);
		
		wall = new MapObject(300, 350, 10, 400);
		RenderableHolder.getInstance().add(wall);
		GameLogic.map.addEntity(wall);
		
		wall = new MapObject(400, 250, 10, 400);
		RenderableHolder.getInstance().add(wall);
		GameLogic.map.addEntity(wall);
		
		wall = new MapObject(500, 350, 10, 400);
		RenderableHolder.getInstance().add(wall);
		GameLogic.map.addEntity(wall);
		
		wall = new MapObject(600, 250, 10, 400);
		RenderableHolder.getInstance().add(wall);
		GameLogic.map.addEntity(wall);
		
		wall = new MapObject(800, 350, 10, 400);
		RenderableHolder.getInstance().add(wall);
		GameLogic.map.addEntity(wall);
		
		wall = new MapObject(1070, 420, 270, 10);
		RenderableHolder.getInstance().add(wall);
		GameLogic.map.addEntity(wall);
		
		
	}
}
