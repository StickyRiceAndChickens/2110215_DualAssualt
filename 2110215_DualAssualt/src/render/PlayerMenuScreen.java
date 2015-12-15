package render;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.awt.image.BufferedImageOp;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class PlayerMenuScreen extends JPanel {

	private boolean p1Ready = false;
	private boolean p2Ready = false;
	private int p1Select = 0;
	private int p2Select = 1;

	public int getP1Select() {
		return p1Select;
	}

	public int getP2Select() {
		return p2Select;
	}

	public PlayerMenuScreen() {

		this.setPreferredSize(new Dimension(SettingScreen.screenWidth, SettingScreen.screenHeight));

		JButton start = new JButton("START!");
		//this.add(start);
		start.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				onNewGame();
			}
		});

		JTextField p1Name = new JTextField();
		JTextField p2Name = new JTextField();
		
		p1Name.setText("Enter your Name");
		p1Name.setBounds(280 * SettingScreen.screenWidth / 1280, 550 * SettingScreen.screenHeight / 720+10,280 * SettingScreen.screenWidth / 1280, 30);
		p1Name.setLocation(280 * SettingScreen.screenWidth / 1280,550 * SettingScreen.screenHeight / 720+10);
		this.add(p1Name);
		//this.add(p2Name);

	}

	protected void onNewGame() {
		// TODO Auto-generated method stub
		if (p1Ready && p2Ready) {
			GameManager.p1.setImage(DrawingUtility.character[p1Select]);
			GameManager.p2.setImage(DrawingUtility.character[p2Select]);
		}
	}

	public void update() {
		
			try {
				Thread.sleep(20);
			} catch (InterruptedException e) {
				if (p1Ready && p2Ready)
					return;
			}
			if (InputUtility.getKeyTriggered(KeyEvent.VK_A))
				p1Select--;
			if (InputUtility.getKeyTriggered(KeyEvent.VK_D))
				p1Select++;
			if (InputUtility.getKeyTriggered(KeyEvent.VK_H))
				p1Ready = !p1Ready;
			if (InputUtility.getKeyTriggered(KeyEvent.VK_LEFT))
				p2Select--;
			if (InputUtility.getKeyTriggered(KeyEvent.VK_RIGHT))
				p2Select++;
			if (InputUtility.getKeyTriggered(KeyEvent.VK_NUMPAD2))
				p2Ready = !p2Ready;
			
		

	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;

		// assign the background color to be "black"
		g2d.setBackground(Color.white);

		// clear all the objects
		Dimension dim = getSize();
		g2d.clearRect(0, 0, (int) dim.getWidth(), (int) dim.getHeight());

		g2d.drawImage(DrawingUtility.resizeImage(DrawingUtility.bgPlayerMenu, 2, SettingScreen.screenWidth,
				SettingScreen.screenHeight), null, 0, 0);
		g2d.drawImage(
				DrawingUtility.resizeImage(DrawingUtility.bgChar, 2, 280 * SettingScreen.screenWidth / 1280,
						460 * SettingScreen.screenHeight / 720),
				null, 220 * SettingScreen.screenWidth / 1280, 90 * SettingScreen.screenHeight / 720);
		g2d.drawImage(
				DrawingUtility.resizeImage(DrawingUtility.bgChar, 2, 280 * SettingScreen.screenWidth / 1280,
						460 * SettingScreen.screenHeight / 720),
				null, (SettingScreen.screenWidth - 500) * SettingScreen.screenWidth / 1280,
				90 * SettingScreen.screenHeight / 720);
		BufferedImage image = DrawingUtility.resizeImage(DrawingUtility.character[p1Select], 2,
				280 * SettingScreen.screenWidth / 1280, 460 * SettingScreen.screenHeight / 720);
		g2d.drawImage(image, null, 220 * SettingScreen.screenWidth / 1280, 90 * SettingScreen.screenHeight / 720);
		image = DrawingUtility.resizeImage(DrawingUtility.character[p2Select], 2,
				280 * SettingScreen.screenWidth / 1280, 460 * SettingScreen.screenHeight / 720);
		g2d.drawImage(image, null,  (SettingScreen.screenWidth-500)*SettingScreen.screenWidth/1280, 90 * SettingScreen.screenHeight / 720);

	}

	// private void defualtButton(int playerID) {
	// if (playerID == 1) {
	// button[0] = KeyEvent.VK_W;
	// button[1] = KeyEvent.VK_A;
	// button[2] = KeyEvent.VK_S;
	// button[3] = KeyEvent.VK_D;
	// button[4] = KeyEvent.VK_G;
	// button[5] = KeyEvent.VK_H;
	// button[6] = KeyEvent.VK_J;
	// } else {
	// button[0] = KeyEvent.VK_UP;
	// button[1] = KeyEvent.VK_LEFT;
	// button[2] = KeyEvent.VK_DOWN;
	// button[3] = KeyEvent.VK_RIGHT;
	// button[4] = KeyEvent.VK_NUMPAD1;
	// button[5] = KeyEvent.VK_NUMPAD2;
	// button[6] = KeyEvent.VK_NUMPAD3;
	// }
	// }

}
