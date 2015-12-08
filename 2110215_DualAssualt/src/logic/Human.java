package logic;

import render.IRenderable;

public abstract class Human implements IRenderable{
	protected int life;
	protected int x,y;
	protected int radius;
	protected int angle;
	protected Weapon weapon;
	
	protected boolean isdead=false;
	
	public Human(int life, int x, int y,int radius, int angle, Weapon weapon) {
		super();
		this.life = life;
		this.x = x;
		this.y = y;
		this.radius=radius;
		this.angle = angle;
		this.weapon = weapon;
	}

	public int getLife() {
		return life;
	}

	public void setLife(int life) {
		this.life = life;
	}
	public void deceaseLife(int life){
		this.life-=life;
		if(this.life<0){
			this.life=0;
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
	public boolean isDead(){
		if(life<=0){
			isdead=true;
		}else{
			isdead=false;
		}
		return isdead;
	}
	
	public abstract void move();
	public void attack(){
		this.weapon.attack();
	}
	public abstract void update();
	
	
}
