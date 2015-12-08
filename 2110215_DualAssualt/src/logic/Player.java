package logic;

import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;

import input.InputUtility;

public class Player extends Human {

	private String name;
	private int playerID;
	private int[] button;
	private BufferedImage image;

	public Player(int life, int x, int y, int radius, int angle, Weapon weapon, String name, int playerID,
			BufferedImage image) {
		super(life, x, y, radius, angle, weapon);
		// TODO Auto-generated constructor stub
		this.name = name;
		this.playerID = playerID;
		if (this.name.equals(null)) {
			this.name = playerID + "P";
		}
		this.button = new int[7];
		defualtButton(playerID);
		this.image = image;

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

	public void setButton(int id, int button) {
		this.button[id] = button;
	}

	public int getPlayerID() {
		return playerID;
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
		return isDead();
	}

	@Override
	public void draw(Graphics2D g2d) {
		// TODO Auto-generated method stub
		g2d.drawImage(image, null, x - radius, y - radius);
	}

	@Override
	public void move() {
		// TODO Auto-generated method stub
		if(InputUtility.getKeyPressed(button[0])){
			x-=1;
		}
		if(InputUtility.getKeyPressed(button[1])){
			y-=1;
		}
		if(InputUtility.getKeyPressed(button[2])){
			x+=1;
		}
		if(InputUtility.getKeyPressed(button[3])){
			y+=1;
		}
		
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void attack() {
		// TODO Auto-generated method stub
		
	}
	
	

}
