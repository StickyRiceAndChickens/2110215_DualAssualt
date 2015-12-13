package logic;

import java.awt.Graphics2D;

import render.IRenderable;

public class DropItem extends Entity implements IRenderable{

	public DropItem(int x, int y, int width,int height) {
		super(x, y, width,height,0);
		// TODO Auto-generated constructor stub
	}

	@Override
	public int getZ() {
		// TODO Auto-generated method stub
		return 99;
	}

	@Override
	public void draw(Graphics2D g2d) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isVisible() {
		// TODO Auto-generated method stub
		return isDestroy();
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}

}
