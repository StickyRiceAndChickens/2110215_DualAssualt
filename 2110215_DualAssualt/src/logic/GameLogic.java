package logic;

import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;


import render.DrawingUtility;
import render.GameBackground;
import render.IRenderable;
import render.InputUtility;
import render.RenderableHolder;

public class GameLogic {

	// All renderable objects
	private GameBackground background;
	Player p1,p2;
	Gun gun1,gun2;
	private static List<Entity> entities = new CopyOnWriteArrayList<Entity>();

	public static void addEntity(Entity e) {
		 entities.add(e);
	}
	
	public static List<Entity> getEntities() {
		return entities;
	}
	/*
	 * Reserved z MIN_VALUE : background MAX_VALUE-1 : animation effect
	 * MAX_VALUE : player's status
	 */
	private int zCounter = Integer.MIN_VALUE + 1;
	private int nextObjectCreationDelay;
	private boolean readyToRender = false; // For dealing with synchronization
											// issue

	// Called before enter the game loop
	public synchronized void onStart() {
		//background = new GameBackground();
		p1 = new Player(50, 100, 100, 10, 0, null, "BF", 1, DrawingUtility.playerImage);
		gun1 = new Gun(100, 100, 10, 0, p1, 0);
		p1.setWeapon(gun1);
		p2 = new Player(50, 200, 200, 10, 0, null, "BF", 0, DrawingUtility.playerImage);
		gun2 = new Gun(100, 100, 10, 0, p2, 1);
		p2.setWeapon(gun2);
		entities.add(p1);
		entities.add(gun1);
		RenderableHolder.getInstance().add(p1);
		entities.add(p2);
		entities.add(gun2);
		RenderableHolder.getInstance().add(p2);
		readyToRender = true;
	}

	// Called after exit the game loop
	public synchronized void onExit() {
		readyToRender = false;

	}

	public void logicUpdate() {
		// Paused
		if (InputUtility.getKeyTriggered(KeyEvent.VK_ENTER)) {
			/* fill code1 */

		}

		// Update moving background
//		background.updateBackground();
		for (int i = 0; i < entities.size(); i++) {
			entities.get(i).update();
		
		}
		// Time up

		// Shoot and grab
		
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
