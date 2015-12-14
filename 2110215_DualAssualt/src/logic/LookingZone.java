package logic;

import java.awt.Graphics2D;
import java.util.ArrayList;

import render.IRenderable;

public class LookingZone {

	int x, y, angle, id;
	Human human;

	public LookingZone(Human human) {

		// TODO Auto-generated constructor stub
		this.human = human;
		this.x = human.getX();
		this.y = human.getY();
		this.angle = human.getAngle();
		this.id = human.getID();
	}

	public int checkLooking(int angle) {
		// Game;
		double xi = x, yi = y;
		int map = 0;
		while (map == 0 || map == id) {
			xi += Math.cos(Math.toRadians(angle));
			yi += Math.sin(Math.toRadians(angle));
			map = GameLogic.map.getTerrainAt((int) xi, (int) yi);

		}
		// System.out.println("look" + " :" + map + "at x:" + xi + " y:" + yi +
		// " map:"
		// + GameLogic.map.getTerrainAt((int) xi, (int) yi));
		return map;

	}
	
	
	public ArrayList<Integer> detectZone(int lookingRange, int angle) {
		ArrayList<Integer> detectIds = new ArrayList<>();
		int missAngle = 0;
		for (int angleI = -lookingRange; angleI <= lookingRange; angleI++) {
			int tmpCheck = checkLooking(angle + angleI);
			if (tmpCheck != 3 && tmpCheck != 0) {
				detectIds.add(tmpCheck);
//				if (missAngle == 0)
//					missAngle = angle + angleI;
			}
			
		}
		
//		if(human instanceof Enemy){
//			((Enemy) human).setMissAngle(missAngle);
//		}
		return detectIds;
	}

	public void update() {
		x = human.getX();
		y = human.getY();
		angle = human.getAngle();
	}

}
