package render;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import logic.GameLogic;
import logic.Player;

@SuppressWarnings("serial")
public class PlayerMenuScreen extends JPanel {

	private boolean p1Ready = false;
	private boolean p2Ready = false;
	public int p1Select = 0;
	public int p2Select = 1;
	public int g1Select = 0;
	public int g2Select = 1;
	private String p1Name, p2Name;
	boolean isClick = false;

	public int getP1Select() {
		return p1Select;
	}

	public int getP2Select() {
		return p2Select;
	}

	public PlayerMenuScreen() {

		this.setPreferredSize(new Dimension(SettingScreen.screenWidth, SettingScreen.screenHeight));

		JButton start = new JButton("START!");

		start.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try {
					onStart();
					p1Name = JOptionPane.showInputDialog(PlayerMenuScreen.this, "Enter your p1name");
					p2Name = JOptionPane.showInputDialog(PlayerMenuScreen.this, "Enter your p2name");
					onNewGame();

					GameLogic.p1 = new Player(50, 700, 400, 70, 40, 0, null, p1Name, 1,
							DrawingUtility.characterIngame[p1Select]);
					GameLogic.p2 = new Player(50, 700, 400, 70, 40, 0, null, p2Name, 2,
							DrawingUtility.characterIngame[p2Select]);

					GameLogic.g1 = g1Select;
					GameLogic.g2 = g2Select;
					p1Ready=false;
					p2Ready=false;
					GameManager.newGame();
				} catch (NameInputException e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(PlayerMenuScreen.this, e1.getMessage());
				} catch (ReadyException e1) {
					JOptionPane.showMessageDialog(PlayerMenuScreen.this, e1.getMessage());
					GameManager.goToPlayerMenu();
				}
			}
		});

		this.add(start);

		// p1Name = new JTextField();
		// p2Name = new JTextField();
		//
		// p1Name.setText("Enter your Name");
		//
		// p1Name.setBounds(280 * SettingScreen.screenWidth / 1280, 550 *
		// SettingScreen.screenHeight / 720 + 10,
		// 280 * SettingScreen.screenWidth / 1280, 30);
		// p1Name.setLocation(280 * SettingScreen.screenWidth / 1280, 550 *
		// SettingScreen.screenHeight / 720 + 10);
		// this.add(p1Name);
		// this.add(start);
		// this.add(p2Name);
		// p2Name.setText("Enter your Name");
		// p2Name.setBounds(280 * SettingScreen.screenWidth / 1280, 550 *
		// SettingScreen.screenHeight / 720 + 10,
		// 280 * SettingScreen.screenWidth / 1280, 30);
		// p2Name.setLocation(280 * SettingScreen.screenWidth / 1280, 550 *
		// SettingScreen.screenHeight / 720 + 10);
		this.addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				InputUtility.setKeyPressed(e.getKeyCode(), false);
			}

			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				InputUtility.setKeyPressed(e.getKeyCode(), true);
				InputUtility.setKeyTriggered(e.getKeyCode(), true);

			}
		});
	}

	protected void onStart() throws ReadyException {
		if (!p1Ready)
			throw new ReadyException(1);
		if (!p2Ready)
			throw new ReadyException(2);
	}

	protected void onNewGame() throws NameInputException {
		// TODO Auto-generated method stub

		if (p1Name.equals(""))
			throw new NameInputException(0, 1);
		else if (p1Name.length() > 6)
			throw new NameInputException(2, 1);
		else if (p2Name.equals(""))
			throw new NameInputException(0, 2);
		else if (p2Name.length() > 6)
			throw new NameInputException(2, 2);
	}

	public void update() {

		try {
			Thread.sleep(20);
		} catch (InterruptedException e) {

		}
		if (!p1Ready) {
			if (InputUtility.getKeyTriggered(KeyEvent.VK_A)) {
				p1Select--;
				if (p1Select < 0)
					p1Select = 4;
			}
			if (InputUtility.getKeyTriggered(KeyEvent.VK_D)) {
				p1Select++;
				if (p1Select > 4)
					p1Select = 0;
			}
			// gun
						if (InputUtility.getKeyTriggered(KeyEvent.VK_S)) {
							g1Select--;
							if (g1Select < 0)
								g1Select = 1;
						}
						if (InputUtility.getKeyTriggered(KeyEvent.VK_W)) {
							g1Select++;
							if (g1Select > 1)
								g1Select = 0;
						}
		}
		if (InputUtility.getKeyTriggered(KeyEvent.VK_H))
			p1Ready = !p1Ready;
		if (!p2Ready) {
			if (InputUtility.getKeyTriggered(KeyEvent.VK_LEFT)) {
				p2Select--;
				if (p2Select < 0)
					p2Select = 4;
			}
			if (InputUtility.getKeyTriggered(KeyEvent.VK_RIGHT)) {
				p2Select++;
				if (p2Select > 4)
					p2Select = 0;
			}
			
			// gun
			if (InputUtility.getKeyTriggered(KeyEvent.VK_DOWN)) {
				g2Select--;
				if (g2Select < 0)
					g2Select = 1;
			}
			if (InputUtility.getKeyTriggered(KeyEvent.VK_UP)) {
				g2Select++;
				if (g2Select > 1)
					g2Select = 0;
			}
		}
		if (InputUtility.getKeyTriggered(KeyEvent.VK_NUMPAD2))
			p2Ready = !p2Ready;

		
		
		repaint();

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
				null, 780 * SettingScreen.screenWidth / 1280, 90 * SettingScreen.screenHeight / 720);
		BufferedImage image = DrawingUtility.resizeImage(DrawingUtility.character[p1Select], 2,
				280 * SettingScreen.screenWidth / 1280, 460 * SettingScreen.screenHeight / 720);
		g2d.drawImage(image, null, 220 * SettingScreen.screenWidth / 1280, 90 * SettingScreen.screenHeight / 720);
		image = DrawingUtility.resizeImage(DrawingUtility.character[p2Select], 2,
				280 * SettingScreen.screenWidth / 1280, 460 * SettingScreen.screenHeight / 720);
		g2d.drawImage(image, null, 780 * SettingScreen.screenWidth / 1280, 90 * SettingScreen.screenHeight / 720);

		g2d.drawImage(DrawingUtility.resizeImage(DrawingUtility.bgGunStatus, 2, 200, 140), null,
				520 * SettingScreen.screenWidth / 1280, 100 * SettingScreen.screenHeight / 720);
		g2d.drawImage(DrawingUtility.resizeImage(DrawingUtility.bgGunStatus, 2, 200, 140), null,
				560 * SettingScreen.screenWidth / 1280, 400 * SettingScreen.screenHeight / 720);
		g2d.drawImage(DrawingUtility.resizeImage(DrawingUtility.gun[g1Select], 2, 160, 110), null,
				530 * SettingScreen.screenWidth / 1280, 110 * SettingScreen.screenHeight / 720);
		g2d.drawImage(DrawingUtility.resizeImage(DrawingUtility.gun[g2Select], 2, 160, 110), null,
				570 * SettingScreen.screenWidth / 1280, 410 * SettingScreen.screenHeight / 720);

		Font stringFont3 = new Font("SansSerif", Font.PLAIN, 30);
		g2d.setColor(Color.RED);
		g2d.setFont(stringFont3);
		if (!p1Ready)
			g2d.drawString("Press h for READY", 240 * SettingScreen.screenWidth / 1280,
					590 * SettingScreen.screenHeight / 720);
		if (!p2Ready)
			g2d.drawString("Press 2 for READY", 800 * SettingScreen.screenWidth / 1280,
					590 * SettingScreen.screenHeight / 720);
		Font stringFont = new Font("SansSerif", Font.PLAIN, 70);
		g2d.setColor(Color.GREEN);
		g2d.setFont(stringFont);
		if (p1Ready)
			g2d.drawString("READY", 240 * SettingScreen.screenWidth / 1280, 620 * SettingScreen.screenHeight / 720);
		if (p2Ready)
			g2d.drawString("READY", 800 * SettingScreen.screenWidth / 1280, 620 * SettingScreen.screenHeight / 720);

		Font stringFont2 = new Font("SansSerif", Font.PLAIN, 20);
		g2d.setColor(Color.YELLOW);
		g2d.setFont(stringFont2);
		g2d.drawString("Player1 : Press A or D to Select Character and W or S to Select Gun", 20,
				650 * SettingScreen.screenHeight / 720);
		g2d.drawString("Player2 : Press LEFT or RIGHT to Select Character and UP or DOWN to Select Gun", 20,
				680 * SettingScreen.screenHeight / 720);

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
