package logic;

import render.DrawingUtility;
import render.RenderableHolder;

public class Level {
	private Enemy e1;
	private Gun gun1;
	private int enemyCount = 0;

	public Level() {
		int x = 500;
		int y = 100;
		while (enemyCount < 12) {
			e1 = new Enemy(30, x, y, 70, 40, 180, null, 3+enemyCount, DrawingUtility.enemy1);
			gun1 = new Gun(x, y, 0, e1, 3);
			e1.setWeapon(gun1);
			RenderableHolder.getInstance().add(e1);
			GameLogic.map.addEntity(e1);
			GameLogic.map.addEntity(gun1);
			enemyCount++;
			y += 100;
			if (y > 500) {
				y = 100;
				x -= 100;
			}
		}
	}
}
