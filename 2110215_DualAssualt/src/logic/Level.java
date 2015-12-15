package logic;

import java.awt.image.BufferedImage;

import render.DrawingUtility;
import render.RenderableHolder;

public class Level {
	private Enemy e1;
	private Gun gun1;
	private int enemyCount = 0;
	private int x[] = {200,220,220,220,400,800,800,800,1100,1100,1100,40};
	private int y[] = {40,200,230,700,40,550,40,200,600,40,200,400,40};
	private BufferedImage imageChar[] = { DrawingUtility.enemy1, DrawingUtility.enemy1, DrawingUtility.enemy1,
			DrawingUtility.enemy1, DrawingUtility.enemy1, DrawingUtility.enemy1, DrawingUtility.enemy2,
			DrawingUtility.enemy2, DrawingUtility.enemy2, DrawingUtility.enemy2, DrawingUtility.enemy2,
			DrawingUtility.enemy3 };

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
	}
}
