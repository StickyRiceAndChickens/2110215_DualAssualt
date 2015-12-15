package logic;

import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import render.IRenderable;
import render.SettingScreen;

public class LookingZone extends Entity {

	int x, y, angle, id;
	Human human;

	public LookingZone(Human human) {
		super(human.getX(), human.getY(), SettingScreen.screenHeight / 2, SettingScreen.screenHeight / 2,
				human.getID());
		// TODO Auto-generated constructor stub
		this.human = human;

		this.angle = human.getAngle();

	}

	public boolean checkLooking(int angle) {
		// Game;
		double xi = x, yi = y;
		
		while (!GameLogic.map.outOfField((int)xi,(int) yi)) {
			xi += Math.cos(Math.toRadians(angle));
			yi += Math.sin(Math.toRadians(angle));
			for (Entity e : GameLogic.map.getEntities())
				if (e != this)
					if (Math.abs((int) xi - e.getX()) <=  xi+x+e.getHeight()) {
						if (Math.abs((int) yi - e.getY()) <= yi+y+e.getHeight()) {
							if(e instanceof Player)
							return true;
						}
					}

		}

		return false;

	}

	public boolean detectZone() {

		for (Entity e : GameLogic.map.getEntities()) {
			if (isOverlap(e)) {
				if (human instanceof Enemy) {
					if (e instanceof Player) {
						return true;
					}
				}
				else if(human instanceof Player){
					if(e instanceof Enemy){
						((Enemy) e).setVisible(true);

					}
				}
			}
		}
		return false;
	}

	public void update() {
		x = human.getX();
		y = human.getY();
		angle = human.getAngle();
	}

}
