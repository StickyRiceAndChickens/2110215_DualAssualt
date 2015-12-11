package logic;

public abstract class Entity {
	protected int x,y;
	public int radius;

	public Entity(int x, int y,int radius) {
		
		this.x = x;
		this.y = y;
		this.radius=radius;
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
	
	public abstract void update();
	
}
