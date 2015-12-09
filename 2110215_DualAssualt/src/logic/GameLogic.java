package logic;

import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import render.GameBackground;
import render.IRenderable;
import render.InputUtility;



public class GameLogic  {

	// All renderable objects
	private GameBackground background;
	
	

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
		background = new GameBackground();
		
		
		
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
		background.updateBackground();

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
