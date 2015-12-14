package logic;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import render.SettingScreen;

public class Map {
	private static int[][] map;
	private List<Entity> entities;

	public Map() {
		map = new int[SettingScreen.screenWidth][SettingScreen.screenHeight - (SettingScreen.screenHeight / 5)];

		entities = new CopyOnWriteArrayList<Entity>();
		for (int w = 0; w < map.length; w++) {
			for (int h = 0; h < map[0].length; h++) {
				map[w][h] = 0;

			}
		}
	}

	public CopyOnWriteArrayList<Entity> getEntities() {
		return (CopyOnWriteArrayList<Entity>) entities;
	}

	public boolean outOfField(int x, int y) {
		if (x >= 0 && x < map.length && y >= 0 && y < map[0].length)
			return false;
		else
			return true;
	}

	public int getTerrainAt(int x, int y) {
		if (!outOfField(x, y))
			return map[x][y];
		else
			return -3;
	}

	public void addEntity(Entity e) {

		entities.add(e);
		if (e instanceof Player) {
			bookingEntityArea(e, ((Player) e).getID());
		} else if (e instanceof Enemy) {
			bookingEntityArea(e, 3);
		} else if (e instanceof MapObject) {
			bookingEntityArea(e, -1);
		}

	}

	private void removeEntity(Entity e) {
		if (e instanceof Human)
			bookingEntityArea(e, 0);

	}

	private void bookingEntityArea(Entity e, int type) {
		for (int w = -e.getHeight(); w < e.getHeight(); w++) {
			for (int h = -e.getWidth(); h < e.getWidth(); h++) {
				map[e.getX() + w][e.getY() + h] = type;

			}
		}
	}

	public void update() {
		for (int i = 0; i < entities.size(); i++) {
			if (entities.get(i).isDestroy()) {
				removeEntity(entities.get(i));
				entities.remove(i);
				i--;
			}
		}
		for (int i = 0; i < entities.size(); i++) {
			int tempX = entities.get(i).getX();
			int tempY = entities.get(i).getY();
			entities.get(i).update();
			UpdateMovingEntity(entities.get(i), tempX, tempY);
			if (entities.get(i) instanceof Bullet) {
				((Bullet) entities.get(i)).isHit();
			}
		}
	}

	void UpdateMovingEntity(Entity e, int tempX, int tempY) {
		int type = 0;
		for (int w = -e.getHeight(); w < e.getHeight(); w++) {
			for (int h = -e.getWidth(); h < e.getWidth(); h++) {
				map[tempX + w][tempY + h] = type;

			}
		}
		if (e instanceof Player) {
			type = ((Player) e).getID();
		} else if (e instanceof Enemy) {
			type = 3;
		} else if (e instanceof MapObject) {
			type = -1;
		}
		
		bookingEntityArea(e, type);
	}
}
