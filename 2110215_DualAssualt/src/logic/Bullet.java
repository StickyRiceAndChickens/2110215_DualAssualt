package logic;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;

import render.IRenderable;

public class Bullet extends Weapon implements IRenderable {

	private Human shooter;
	private int power;
	private int speed;

	private int hitAngle;

	public Bullet(int x, int y, int angle, int power, int speed, Human shooter) {
		super(x, y, 6, 6, angle);
		// TODO Auto-generated constructor stub

		this.power = power;
		this.speed = speed;
		this.shooter = shooter;
	}

	@Override
	public void move() {
		// TODO Auto-generated method stub
		if (!isDestroy()) {
			x = (int) (x + speed * Math.cos(Math.toRadians(angle)));
			y = (int) (y + speed * Math.sin(Math.toRadians(angle)));
			if (GameLogic.map.outOfField((int) x, (int) y))
				isDestroy = true;
		}
	}

	public boolean isHit() {
		// TODO Auto-generated method stub

		if (!this.isDestroy())
			for (Entity e : GameLogic.map.getEntities()) {
				if (this.isOverlap(e)) {
					if (e != shooter && e != shooter.getWeapon()) {
						{
							if (!(e instanceof LookingZone)) {
								this.isDestroy = true;
								if (e instanceof Human) {
									((Human) e).deceaseLife(power);
									if (e instanceof Enemy)
										((Enemy) e).setHitAngle(angle);
									return true;
								}
							}
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

		Ellipse2D.Double shape = new Ellipse2D.Double(x, y, width, height);
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
