package logic;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.concurrent.CopyOnWriteArrayList;

import render.SettingScreen;

public class Map {
	
	private List<Entity> entities;

	public Map() {
		

		entities = new CopyOnWriteArrayList<Entity>();
		
	}

	public List<Entity> getEntities() {
		return (CopyOnWriteArrayList<Entity>) entities;
	}

	public boolean outOfField(int x, int y) {
		if (x >= 0 && x < SettingScreen.screenWidth && y >= 0 && y < SettingScreen.screenHeight - (SettingScreen.screenHeight / 5))
			return false;
		else
			return true;
	}

	

	public synchronized void addEntity(Entity e) {

		entities.add(e);

		

	}

	

	

	public synchronized void update() {

		for(int i=0;i<entities.size();i++){
			
			if (entities.get(i).isDestroy()) {
				
				entities.remove(i);
				i--;

			}
		}
		
		for (int i = 0; i < entities.size(); i++) {
			int tempX = entities.get(i).getX();
			int tempY = entities.get(i).getY();
			entities.get(i).update();
			
			
		}
	}

	
}
