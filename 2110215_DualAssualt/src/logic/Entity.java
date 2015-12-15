package logic;

public abstract class Entity {
	protected int x, y;
	public int width, height;
	protected boolean isDestroy;
	protected int id;

	public Entity(int x, int y, int width, int height, int id) {

		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.isDestroy = false;
		this.id = id;
	}

	public int getID() {
		return id;
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	public boolean isDestroy() {
		return isDestroy;
	}

	public void setDestroy(boolean isDestroy) {
		this.isDestroy = isDestroy;
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

	public boolean isOverlap(Entity e) {
		if (e != this)
			if (!(e instanceof LookingZone))
				if (Math.abs(this.x - e.getX()) <= this.height + e.getHeight()) {
					
						return true;
					
				}
		return false;
	}

}
