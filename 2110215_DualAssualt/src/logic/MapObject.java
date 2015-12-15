package logic;

import java.awt.Color;
import java.awt.Graphics2D;

import render.IRenderable;

public class MapObject extends Entity implements IRenderable{

	public MapObject(int x, int y, int width, int height) {
		super(x, y, width, height,-1);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub

	}

	@Override
	public int getZ() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void draw(Graphics2D g2d) {
		// TODO Auto-generated method stub
		g2d.setColor(new Color(55,33,12));
		g2d.drawRect(x-width/2, y-height/2, width, height);
	}

	@Override
	public boolean isVisible() {
		// TODO Auto-generated method stub
		return true;
	}

}
