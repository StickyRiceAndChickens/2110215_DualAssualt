package logic;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;

import render.IRenderable;

public class Bullet extends Weapon implements IRenderable {

	
	private Human shooter;
	private int power;
	private int speed;
	private double x,y;

	public Bullet(int x, int y, int angle, int power, int speed, Human shooter) {
		super(x, y, 6, angle);
		// TODO Auto-generated constructor stub
		this.x=(double)x;
		this.y=(double)y;
		this.power = power;
		this.speed = speed;
		this.shooter = shooter;
	}

	@Override
	public void move() {
		// TODO Auto-generated method stub
		if (!isDestroy()) {
			x = (x +  speed * Math.cos(Math.toRadians(angle)));
			y = (y +  speed * Math.sin(Math.toRadians(angle)));

		}
	}

	public boolean isHit() {
		// TODO Auto-generated method stub
		if(!this.isDestroy())
		for (Entity e : GameLogic.getEntities()) {
			if (e != shooter && e != shooter.getWeapon()) {
				if (!(e instanceof Bullet)) {
					if (Math.hypot(this.x - e.x, this.y - e.y) <= this.radius + e.radius) {

						this.isDestroy = true;
						if (e instanceof Human) {
							((Human) e).deceaseLife(power);
						}
						return true;
					}
				}
			}
		}
		return false;

	}

	@Override
	public int getZ() {
		// TODO Auto-generated method stub
		return 100;
	}

	@Override
	public void draw(Graphics2D g2d) {
		// TODO Auto-generated method stub
		g2d.setColor(Color.black);
		
		Ellipse2D.Double shape = new Ellipse2D.Double(x, y, radius, radius);
	    g2d.fill(shape);
		
	}

	@Override
	public boolean isVisible() {
		// TODO Auto-generated method stub
		return !isDestroy;
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		move();
		isHit();
	}

	@Override
	public void attack() {
		// TODO Auto-generated method stub

	}

}
