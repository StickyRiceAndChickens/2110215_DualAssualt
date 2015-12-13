package logic;

import java.awt.Graphics2D;

import render.IRenderable;

public class LookingZone	extends Entity implements IRenderable{
	
	int angle;
	
	public LookingZone(int x, int y, int width, int height,int angle) {
		super(x, y, width, height,0);
		// TODO Auto-generated constructor stub
		this.angle=angle;
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
	public void update() {
		// TODO Auto-generated method stub
		
	}

}
