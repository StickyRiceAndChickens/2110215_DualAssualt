package logic;

import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import render.DrawingUtility;

public class Enemy extends Human {

	private int prevLife;
	private LookingZone look;
	private BufferedImage image;
	private boolean isMiss = false;
	private int hitAngle = 0;
	private int missAngle = 0;
	private boolean isVisible = false;

	public void setMissAngle(int missAngle) {
		this.missAngle = missAngle;
	}

	public void setHitAngle(int hitAngle) {
		this.hitAngle = hitAngle;
	}

	public Enemy(int life, int x, int y, int width, int height, int angle, Weapon weapon, int id, BufferedImage image) {
		super(life, x, y, width, height, angle, weapon, id);
		// TODO Auto-generated constructor stub
		this.prevLife = life;
		this.look = new LookingZone(this);
		this.image = DrawingUtility.resizeImage(image, image.getType(), width, height);
		;
	}

	public boolean getHit() {
		if (prevLife > life) {
			prevLife = life;
			return true;
		} else
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
		AffineTransform at = new AffineTransform();

		// 4. translate it to the center of the component
		at.translate(x, y);

		// 3. do the actual rotation
		at.rotate(Math.toRadians(angle));

		// 2. just a scale because this image is big
		at.scale(1, 1);

		// 1. translate the object so that you rotate it around the
		// center (easier :))
		at.translate(-image.getWidth() / 2, -image.getHeight() / 2);
		g2d.drawImage(image, at, null);
	}

	@Override
	public boolean isVisible() {
		// TODO Auto-generated method stub

		return !isDestroy();
	}

	public void setVisible(boolean isVisible) {
		this.isVisible = isVisible;
	}

	@Override
	public void move() {
		// TODO Auto-generated method stub

		if (isMiss) {
			angle++;
		}
		if (getHit())
			angle = 180 + hitAngle;
		if (angle == 360)
			angle = 0;
	}

	@Override
	public void attack() {
		// TODO Auto-generated method stub
		if (look.detectZone()) {

			weapon.attack();
			if (!look.checkLooking(angle)) {
				isMiss = true;

			} else {
				isMiss = false;
				missAngle = 0;
			}
			return;
		}

	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		attack();
		move();

	}

}
