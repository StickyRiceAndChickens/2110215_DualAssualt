package logic;

import render.IRenderable;

public abstract class Human extends Entity implements IRenderable {

	protected int life;
	protected int angle;
	protected Weapon weapon;
	protected int id;

	public Human(int life, int x, int y, int width, int height, int angle, Weapon weapon,int id) {
		super(x, y, width, height,id);
		this.life = life;
		this.angle = angle;
		this.weapon = weapon;
		
	}
	
	public int getLife() {
		return life;
	}

	public void setLife(int life) {
		this.life = life;
	}

	public void deceaseLife(int life) {
		this.life -= life;
		if (this.life < 0) {
			this.life = 0;
			isDestroy = true;
		}

	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getAngle() {
		return angle;
	}

	public void setAngle(int angle) {
		this.angle = angle;
	}

	public Weapon getWeapon() {
		return weapon;
	}

	public void setWeapon(Weapon weapon) {
		this.weapon = weapon;
	}

	public abstract void move();

	public abstract void attack();

	public abstract void update();

}
