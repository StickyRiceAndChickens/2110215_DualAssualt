package logic;

import java.awt.Graphics2D;

public class Enemy extends Human {

	
	public Enemy(int life, int x, int y, int radius, int angle, Weapon weapon) {
		super(life, x, y, radius, angle, weapon);
		// TODO Auto-generated constructor stub
	}

	@Override
	public int getZ() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void draw(Graphics2D g2d) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isVisible() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void move() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void attack() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}

}
