package logic;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.concurrent.CopyOnWriteArrayList;

import render.AudioUtility;
import render.GameManager;
import render.InputUtility;
import render.SettingScreen;

public class Map {

	private List<Entity> entities;

	private int score;

	private boolean isPause = false;

	public boolean isPause() {
		return isPause;
	}

	public void setPause(boolean isPause) {
		this.isPause = isPause;
	}

	public Map() {

		entities = new CopyOnWriteArrayList<Entity>();
		score = 0;
	}

	public int getScore() {
		return score;
	}

	public void addScore(int score) {
		this.score += score;
	}

	public List<Entity> getEntities() {
		return (CopyOnWriteArrayList<Entity>) entities;
	}

	public boolean outOfField(int x, int y) {
		if (x >= 0 && x < SettingScreen.screenWidth && y >= 0
				&& y < SettingScreen.screenHeight - (SettingScreen.screenHeight / 5))
			return false;
		else
			return true;
	}

	public synchronized void addEntity(Entity e) {

		entities.add(e);

	}

	public synchronized void update() {

		for (int i = 0; i < entities.size(); i++) {

			if (entities.get(i).isDestroy()) {
				if (entities.get(i) instanceof Enemy) {
					GameLogic.map.addScore(500);
					GameLogic.level.decreaseEnemyCount();
					AudioUtility.playSound("kill");
				}
				entities.remove(i);
				i--;

			}
		}
		for (int i = 0; i < entities.size(); i++) {

			entities.get(i).update();

		}

	}

	public boolean isWin() {
		if (GameLogic.level.getEnemyCount() == 0) {
			addScore(5000);
			AudioUtility.playSound("win");
			return true;
		}
		return false;
	}

	public boolean isLose() {
		if (GameLogic.p1.getLife() == 0 && GameLogic.p2.getLife() == 0) {
			addScore(-500);
			AudioUtility.playSound("lose");
			return true;
		}
		return false;
	}

	public boolean isGameOver() {
		if (isWin() || isLose())
			return true;
		else
			return false;
	}

}
