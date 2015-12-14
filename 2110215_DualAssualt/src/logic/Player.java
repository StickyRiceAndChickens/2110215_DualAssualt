package logic;

import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;

import render.DrawingUtility;
import render.InputUtility;

public class Player extends Human {

	private String name;

	private int[] button;
	private BufferedImage image;
	private int speed = 3;
	private LookingZone look;

	public Player(int life, int x, int y, int width, int height, int angle, Weapon weapon, String name, int playerID,
			BufferedImage image) {
		super(life, x, y, width, height, angle, weapon, playerID);
		// TODO Auto-generated constructor stub
		this.name = name;

		this.button = new int[7];
		defualtButton(playerID);
		this.image = DrawingUtility.resizeImage(image, image.getType(), width, height);
		look = new LookingZone(this);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int[] getButton() {
		return button;
	}

	public int getButton(int b) {
		return button[b];
	}

	public void setButton(int id, int button) {
		this.button[id] = button;
	}

	private void defualtButton(int playerID) {
		if (playerID == 1) {
			button[0] = KeyEvent.VK_W;
			button[1] = KeyEvent.VK_A;
			button[2] = KeyEvent.VK_S;
			button[3] = KeyEvent.VK_D;
			button[4] = KeyEvent.VK_G;
			button[5] = KeyEvent.VK_H;
			button[6] = KeyEvent.VK_J;
		} else {
			button[0] = KeyEvent.VK_UP;
			button[1] = KeyEvent.VK_LEFT;
			button[2] = KeyEvent.VK_DOWN;
			button[3] = KeyEvent.VK_RIGHT;
			button[4] = KeyEvent.VK_NUMPAD1;
			button[5] = KeyEvent.VK_NUMPAD2;
			button[6] = KeyEvent.VK_NUMPAD3;
		}
	}

	@Override
	public int getZ() {
		// TODO Auto-generated method stub
		return 100;
	}

	@Override
	public boolean isVisible() {
		// TODO Auto-generated method stub
		return !isDestroy;
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
	public void move() {
		// TODO Auto-generated method stub
		int tempX = x;
		int tempY = y;
		if (InputUtility.getKeyPressed(button[0])) {

			y -= speed;
		}
		if (InputUtility.getKeyPressed(button[1])) {
			x -= speed;
		}
		if (InputUtility.getKeyPressed(button[2])) {
			y += speed;
		}
		if (InputUtility.getKeyPressed(button[3])) {
			x += speed;
		}
		if (InputUtility.getKeyPressed(button[4])) {
			angle -= 7;
			if (angle < 0)
				angle = 360;
		} else if (InputUtility.getKeyPressed(button[6])) {
			angle += 7;
			if (angle > 360)
				angle = 0;
		}
		
		try {
			GameLogic.map.UpdateMovingEntity(this, x, y);
		} catch (ArrayIndexOutOfBoundsException e) {
			x = tempX;
			y = tempY;
		}
		look.update();
		
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		move();
		attack();

	}

	@Override
	public void attack() {
		// TODO Auto-generated method stub
		if (InputUtility.getKeyTriggered(button[5])) {
			weapon.attack();
			// System.out.print("use");
		}
	}

}
