package logic;

public abstract class Weapon extends Entity{
	
	
	protected int angle;
	protected int power;
	protected int speed;
	
	
	public Weapon(int x, int y, int radius,int angle, int power, int speed) {
		super(x,y,radius);
		
		this.angle = angle;
		this.power = power;
		this.speed = speed;
	}
	
	public abstract void attack();
	public abstract boolean isHit(Entity e);

	
	

}
