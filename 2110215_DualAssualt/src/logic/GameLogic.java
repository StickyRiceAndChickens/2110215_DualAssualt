package logic;

import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import javax.swing.JOptionPane;

import render.AudioUtility;
import render.DrawingUtility;
import render.GameBackground;
import render.GameManager;
import render.GameScreen;
import render.GameWindow;
import render.IRenderable;
import render.InputUtility;
import render.RenderableHolder;
import render.SettingScreen;

public class GameLogic {

	// All renderable objects
	private GameBackground background;
	public static Player p1, p2;

	private Gun gun1, gun2;
	public static Map map;
	public static int g1, g2;
	

	private boolean readyToRender = false; // For dealing with synchronization

	public static Level level;

	public GameLogic() {
		p1 = new Player(50, 700, 400, 70, 40, 0, null, "Bigfern", 1, DrawingUtility.enemy1);
		p2 = new Player(50, 300, 400, 70, 40, 0, null, "เกรท", 2, DrawingUtility.enemy2);
	}

	// Called before enter the game loop
	public synchronized void onStart() {
		background = new GameBackground();
		map = new Map();
		// set Player 1

		gun1 = new Gun(800, 200, 0, p1, g1);
		p1.setLife(50);
		p1.setWeapon(gun1);
		map.addEntity(p1);
		RenderableHolder.getInstance().add(p1);
		map.addEntity(gun1);
		// set Player 2
		gun2 = new Gun(700, 400, 0, p2, g2);
		p2.setLife(50);
		p2.setWeapon(gun2);
		map.addEntity(p2);
		RenderableHolder.getInstance().add(p2);
		map.addEntity(gun2);
		// status bar
		GameStatusBar status = new GameStatusBar(p1, p2);
		status.setP1(p1);
		status.setP2(p2);
		RenderableHolder.getInstance().add(status);
		RenderableHolder.getInstance().add(background);

		level = new Level();

		readyToRender = true;

		background.updateBackground();

	}

	// Called after exit the game loop
	public synchronized void onExit() {
		readyToRender = false;
		List<IRenderable> holder = RenderableHolder.getInstance().getRenderableList();
		for (int i = 0; i < holder.size(); i++) {
			if (holder.get(i) instanceof Entity || holder.get(i) instanceof GameStatusBar) {

				holder.remove(i);
				i--;

			}
		}

	}

	public void logicUpdate() {

		// Paused

		if (InputUtility.getKeyTriggered(KeyEvent.VK_ESCAPE)) {
			if (!map.isPause())
				map.setPause(true);
			else {
				map.setPause(false);
			}
		}
		map.update();
		InputUtility.postUpdate();
		if (map.isGameOver()){
			JOptionPane.showMessageDialog(GameManager.gameScreen,"Your score is "+map.getScore());
			AudioUtility.gameSong.stop();
			GameManager.goToTitle();
			
		}

		List<IRenderable> holder = RenderableHolder.getInstance().getRenderableList();
		for (int i = 0; i < holder.size(); i++) {
			if (holder.get(i) instanceof Entity) {
				if (((Entity) holder.get(i)).isDestroy()) {
					holder.remove(i);
					i--;
				}

			}
		}

	}

	public synchronized List<IRenderable> getSortedRenderableObject() {
		List<IRenderable> sortedRenderable = new ArrayList<IRenderable>();
		if (!readyToRender)
			return sortedRenderable;

		Collections.sort(sortedRenderable, new Comparator<IRenderable>() {
			@Override
			public int compare(IRenderable o1, IRenderable o2) {
				if (o1.getZ() > o2.getZ())
					return 1;
				else if (o1.getZ() < o2.getZ())
					return -1;
				else
					return 0;
			}
		});
		return sortedRenderable;
	}
}
