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

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class PlayerMenuScreen extends JPanel {
	
	public boolean p1Ready = false;
	public boolean p2Ready = false;
	private int[] button;
	
	public PlayerMenuScreen(){
		
		this.setPreferredSize(new Dimension(SettingScreen.screenWidth, SettingScreen.screenHeight));
		
		JButton start = new JButton("START!");
		this.add(start);
		start.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				GameManager.newGame();
			}
		});
		
		
		JTextField p1Name = new JTextField();
		JTextField p2Name = new JTextField();
		p1Name.setPreferredSize(new Dimension(150, 30));
		p1Name.setText("HELOO");
		
		this.add(p1Name);
		this.add(p2Name);
		
		this.addListener();
		
	}
	
	
	private void addListener() {
		/* fill code listener1 */
		this.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				InputUtility.setMouseLeftDown(false);
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				if (e.getButton() == MouseEvent.BUTTON1) {
					// label.setText("Detected Mouse Left Click!");
					InputUtility.setMouseLeftDown(true);
					InputUtility.setMouseLeftTriggered(true);
				} else if (e.getButton() == MouseEvent.BUTTON3) {
					// label.setText("Detected Mouse Right Click!");
				}
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				InputUtility.setMouseOnScreen(false);
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				InputUtility.setMouseOnScreen(true);
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub

			}
		});
		/* fill code listener2 */
		this.addMouseMotionListener(new MouseMotionListener() {

			@Override
			public void mouseMoved(MouseEvent e) {
				// TODO Auto-generated method stub
				if (InputUtility.isMouseOnScreen()) {
					InputUtility.setMouseX(e.getX());
					InputUtility.setMouseY(e.getY());
				}
			}

			@Override
			public void mouseDragged(MouseEvent e) {
				// TODO Auto-generated method stub
				if (InputUtility.isMouseOnScreen()) {
					InputUtility.setMouseX(e.getX());
					InputUtility.setMouseY(e.getY());
				}
			}
		});
		/* fill code listener3 */
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
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;
		
		// assign the background color to be "black"
		g2d.setBackground(Color.white);

		// clear all the objects
		Dimension dim = getSize();
		g2d.clearRect(0, 0, (int) dim.getWidth(), (int) dim.getHeight());
				
		g2d.drawImage(DrawingUtility.resizeImage(DrawingUtility.bgPlayerMenu, 2, SettingScreen.screenWidth, SettingScreen.screenHeight), null, 0, 0);
		
//		if (InputUtility.getKeyTriggered(KeyEvent.VK_A)) currentChar = 
		
	}
	
//	private void defualtButton(int playerID) {
//		if (playerID == 1) {
//			button[0] = KeyEvent.VK_W;
//			button[1] = KeyEvent.VK_A;
//			button[2] = KeyEvent.VK_S;
//			button[3] = KeyEvent.VK_D;
//			button[4] = KeyEvent.VK_G;
//			button[5] = KeyEvent.VK_H;
//			button[6] = KeyEvent.VK_J;
//		} else {
//			button[0] = KeyEvent.VK_UP;
//			button[1] = KeyEvent.VK_LEFT;
//			button[2] = KeyEvent.VK_DOWN;
//			button[3] = KeyEvent.VK_RIGHT;
//			button[4] = KeyEvent.VK_NUMPAD1;
//			button[5] = KeyEvent.VK_NUMPAD2;
//			button[6] = KeyEvent.VK_NUMPAD3;
//		}
//	}

}
