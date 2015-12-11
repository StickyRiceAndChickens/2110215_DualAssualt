package logic;

import java.awt.Color;
import java.awt.Graphics2D;

import render.IRenderable;

public class Bullet extends Weapon implements IRenderable {

	private boolean isDestroyed = false;
	private Human shooter;
	private int power;
	private int speed;

	public Bullet(int x, int y, int angle, int power, int speed, Human shooter) {
		super(x, y, 2, angle);
		// TODO Auto-generated constructor stub
		this.power = power;
		this.speed = speed;
		this.shooter = shooter;
	}

	@Override
	public void move() {
		// TODO Auto-generated method stub
		if (!isDestroyed) {
			x = x + speed * (int) Math.cos(angle);
			y = y + speed * (int) Math.sin(angle);
		}
	}

	public boolean isHit(Entity e) {
		// TODO Auto-generated method stub
		if (e != shooter) {
			if (Math.hypot(this.x - e.x, this.y - e.y) <= this.radius + e.radius) {

				this.isDestroyed = true;
				if (e instanceof Human) {
					((Human) e).deceaseLife(power);
				}
				return true;
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
		g2d.fillOval(x - 1, y - 1, 2, 2);
	}

	@Override
	public boolean isVisible() {
		// TODO Auto-generated method stub
		return !isDestroyed;
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		move();
	}

	@Override
	public void attack() {
		// TODO Auto-generated method stub

	}

}
