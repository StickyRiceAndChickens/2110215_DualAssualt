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
import render.SettingScreen;

public class GameLogic {

	// All renderable objects
	private GameBackground background;
	private Player p1, p2;
	private Enemy e1, e2;
	private Gun gun1, gun2,gun3,gun4;
	public static Map map;

	

	

	/*
	 * Reserved z MIN_VALUE : background MAX_VALUE-1 : animation effect
	 * MAX_VALUE : player's status
	 */
	private int idCounter =  3;
	private int nextObjectCreationDelay;
	private boolean readyToRender = false; // For dealing with synchronization
											// issue

	// Called before enter the game loop
	public synchronized void onStart() {
		background = new GameBackground();
		map=new Map();
		p1 = new Player(50, 800, 200, 70, 40, 0, null, "BF", 1, DrawingUtility.playerImage);
		gun1 = new Gun(800, 200, 0, p1, 0);
		p1.setWeapon(gun1);
		p2 = new Player(50, 700, 400, 70, 40, 0, null, "BF", 2, DrawingUtility.playerImage);
		gun2 = new Gun(700, 400, 0, p2, 1);
		
		p2.setWeapon(gun2);
		map.addEntity(p1);
		map.addEntity(gun1);
		RenderableHolder.getInstance().add(p1);
		map.addEntity(p2);
		map.addEntity(gun2);
		RenderableHolder.getInstance().add(p2);
		GameStatusBar status = new GameStatusBar(p1, p2);
		RenderableHolder.getInstance().add(status);
		RenderableHolder.getInstance().add(background);
		
		e1=new Enemy(30, 500, 200, 70, 40, 180, null, 3,DrawingUtility.playerImage);
		gun3 = new Gun(500, 200, 0, e1, 3);
		
		e1.setWeapon(gun3);
		map.addEntity(e1);
		map.addEntity(gun3);
		RenderableHolder.getInstance().add(e1);
		
		e2=new Enemy(30, 100, 100, 70, 40, 0, null, 4,DrawingUtility.playerImage);
		gun4 = new Gun(100, 100, 0, e2, 3);
		
		e2.setWeapon(gun4);
		map.addEntity(e2);
		map.addEntity(gun4);
		RenderableHolder.getInstance().add(e2);
		
		readyToRender = true;
		System.out.println("Map:");
		background.updateBackground();
		for(int h=0;h<SettingScreen.screenHeight/4;h++){
			for(int w=0;w<SettingScreen.screenWidth/4;w++){
				System.out.print(map.getTerrainAt(w, h));
			}
			System.out.println();
		}
	}

	// Called after exit the game loop
	public synchronized void onExit() {
		readyToRender = false;

	}

	public void logicUpdate() {

		// Paused
		if (InputUtility.getKeyTriggered(KeyEvent.VK_ENTER)) {
			
			System.out.println("Enter");
		}

		// Update moving background
		
		map.update();
		
		InputUtility.postUpdate();

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
