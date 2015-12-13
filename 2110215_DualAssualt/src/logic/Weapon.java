package logic;

public abstract class Weapon extends Entity {

	protected int angle;

	public Weapon(int x, int y, int width, int height, int angle) {
		super(x, y, width, height,0);

		this.angle = angle;

	}

	public abstract void move();

	public abstract void attack();

}
