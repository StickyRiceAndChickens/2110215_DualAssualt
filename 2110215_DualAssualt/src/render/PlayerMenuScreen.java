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
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.awt.image.BufferedImageOp;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

import logic.GameLogic;

@SuppressWarnings("serial")
public class PlayerMenuScreen extends JPanel {

	private boolean p1Ready = false;
	private boolean p2Ready = false;
	public int p1Select = 0;
	public int p2Select = 1;
	public int g1Select=0;
	public int g2Select=1;
	JTextField p1Name,p2Name;
	boolean isClick=false;

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
					onNewGame();
				} catch (ReadyException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				GameManager.p1.setImage(DrawingUtility.characterIngame[p1Select]);

				GameManager.p2.setImage(DrawingUtility.characterIngame[p2Select]);
				GameLogic.g1=g1Select;
				GameLogic.g2=g2Select;
				GameManager.newGame();
			}
		});

		p1Name = new JTextField();
		p2Name = new JTextField();

		p1Name.setText("Enter your Name");
		p1Name.setBounds(280 * SettingScreen.screenWidth / 1280, 550 * SettingScreen.screenHeight / 720 + 10,
				280 * SettingScreen.screenWidth / 1280, 30);
		p1Name.setLocation(280 * SettingScreen.screenWidth / 1280, 550 * SettingScreen.screenHeight / 720 + 10);
		this.add(p1Name);
		this.add(start);
		this.add(p2Name);
		p2Name.setText("Enter your Name");
		p2Name.setBounds(280 * SettingScreen.screenWidth / 1280, 550 * SettingScreen.screenHeight / 720 + 10,
				280 * SettingScreen.screenWidth / 1280, 30);
		p2Name.setLocation(280 * SettingScreen.screenWidth / 1280, 550 * SettingScreen.screenHeight / 720 + 10);
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

	protected void onNewGame() throws ReadyException{
		// TODO Auto-generated method stub
		
			if (p1Name.getText() == null)
				throw new ReadyException(0,1);
			else if(p1Name.getText().length()>16)
				throw new ReadyException(2,1);
			else if(!p1Ready)
				throw new ReadyException(3,1);
			else if (p2Name.getText() == null)
				throw new ReadyException(0,2);
			else if(p2Name.getText().length()>16)
				throw new ReadyException(2,2);
			else if(!p2Ready)
				throw new ReadyException(3,2);
			try{
				String str=p1Name.getText().toString();
			}catch(NumberFormatException e){
				throw new ReadyException(1,1);
			}
			try{
				String str=p2Name.getText().toString();
			}catch(NumberFormatException e){
				throw new ReadyException(1,2);
			}
		
		
	}

	public void update() {

		try {
			Thread.sleep(20);
		} catch (InterruptedException e) {
			if (p1Ready && p2Ready)
				return;
		}
		if (InputUtility.getKeyTriggered(KeyEvent.VK_A)) {
			p1Select--;
			if (p1Select < 0) p1Select = 4;
		}
		if (InputUtility.getKeyTriggered(KeyEvent.VK_D)) {
			p1Select++;
			if (p1Select > 4) p1Select = 0;
		}
		if (InputUtility.getKeyTriggered(KeyEvent.VK_H))
			p1Ready = !p1Ready;
		if (InputUtility.getKeyTriggered(KeyEvent.VK_LEFT)) {
			p2Select--;
			if (p2Select < 0) p2Select = 0;
		}
		if (InputUtility.getKeyTriggered(KeyEvent.VK_RIGHT)) {
			p2Select++;
			if (p2Select > 4) p2Select = 0;
		}
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
		g2d.drawImage(image, null, (SettingScreen.screenWidth - 500) * SettingScreen.screenWidth / 1280,
				90 * SettingScreen.screenHeight / 720);
		
		g2d.drawImage(DrawingUtility.resizeImage(DrawingUtility.bgGunStatus, 2, 200, 140), null, 520, 100);
		g2d.drawImage(DrawingUtility.resizeImage(DrawingUtility.bgGunStatus, 2, 200, 140), null, 560, 400);
		g2d.drawImage(DrawingUtility.resizeImage(DrawingUtility.gun[g1Select], 2, 160, 110),null,530,110);
		g2d.drawImage(DrawingUtility.resizeImage(DrawingUtility.gun[g2Select], 2, 160, 110),null,570,410);
		
		Font stringFont = new Font( "SansSerif", Font.PLAIN, 70 );
		g2d.setColor(Color.GREEN);
		g2d.setFont(stringFont);
		if (!p1Ready) g2d.drawString("READY", 240*SettingScreen.screenWidth/1280, 600*SettingScreen.screenHeight/720);
		if (!p2Ready) g2d.drawString("READY", 800*SettingScreen.screenWidth/1280, 600*SettingScreen.screenHeight/720);

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
