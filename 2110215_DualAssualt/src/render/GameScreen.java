package render;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JPanel;





public class GameScreen extends JPanel {

	private RenderableHolder renderableHolder;
	

	protected GameScreen() {
		
		this.setPreferredSize(new Dimension(SettingScreen.screenWidth, SettingScreen.screenHeight));
		
		this.addListener();
		this.validate();
		setDoubleBuffered(true);
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

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponents(g);
		Graphics2D g2 = (Graphics2D) g;
		
		// assign the background color to be "black"
		g2.setBackground(Color.white);

		// clear all the objects
		Dimension dim = getSize();
		g2.clearRect(0, 0, (int) dim.getWidth(), (int) dim.getHeight());

		// render all the objects
		for (IRenderable renderable :RenderableHolder.getInstance().getRenderableList()) {
			if(renderable.isVisible())
			renderable.draw(g2);
			
		}
	}

	/**
	 * 
	 */
	
}
