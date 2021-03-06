package logic;

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
				if(e instanceof Player)
					if (Math.abs((int) xi - e.getX()) <= e.getWidth()/2) {
						if (Math.abs((int) yi - e.getY()) <= e.getHeight()/2) {
							
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
