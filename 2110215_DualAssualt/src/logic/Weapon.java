package logic;

import java.awt.Graphics2D;

import render.IRenderable;

public class Weapon implements IRenderable {
	
	protected int x,y;
	protected int angle;
	protected int power;
	protected int speed;
	
	public void attack() {
		// TODO Auto-generated method stub
		
	}
	public boolean isHit(){
		
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

}
