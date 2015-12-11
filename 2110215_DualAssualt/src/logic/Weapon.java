package logic;

public abstract class Weapon extends Entity{
	
	
	protected int angle;
	
	
	
	public Weapon(int x, int y, int radius,int angle) {
		super(x,y,radius);
		
		this.angle = angle;
		
	}
	
	public abstract void move();
	public abstract void attack();

	
	

}
