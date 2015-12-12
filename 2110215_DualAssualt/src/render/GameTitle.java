package render;

import java.awt.BorderLayout;
import java.awt.Color;import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;



@SuppressWarnings("serial")
public class GameTitle extends JPanel {
	TitleBackground background;
	public GameTitle() {
		this.setPreferredSize(new Dimension(SettingScreen.screenWidth, SettingScreen.screenHeight));
		this.setLayout(new BorderLayout());
		JPanel westPanel = new JPanel();
		westPanel.setBackground(Color.DARK_GRAY);
		westPanel.setLayout(new GridLayout(6,1));
		
		westPanel.setPreferredSize(new Dimension(300, 500));
		
		EmptyPanel1 emptyPanel1 = new EmptyPanel1();
		EmptyPanel2 emptyPanel2 = new EmptyPanel2();
		EmptyPanel3 emptyPanel3 = new EmptyPanel3();
		westPanel.add(emptyPanel1);
		westPanel.add(emptyPanel2);
		westPanel.add(emptyPanel3);
		
		background= new TitleBackground();
		
		NewGamePanel newGamePanel = new NewGamePanel();
		newGamePanel.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				GameManager.newGame();
			}
		});
		SettingPanel settingPanel = new SettingPanel();
		settingPanel.setPreferredSize(new Dimension(300, 100));
		QuitPanel quitPanel = new QuitPanel();
		quitPanel.setPreferredSize(new Dimension(300, 100));
		westPanel.add(newGamePanel);
		westPanel.add(settingPanel);
		westPanel.add(quitPanel);
		
		

		
		this.add(westPanel, BorderLayout.WEST);
		
		

	}
	
	//emptyPanel
	public class EmptyPanel1 extends JPanel {
		public EmptyPanel1() {
			// TODO Auto-generated constructor stub
			setPreferredSize(new Dimension(300, 100));
			 setOpaque(false);
		}
		@Override
		protected void paintComponent(Graphics g) {
			// TODO Auto-generated method stub
			super.paintComponent(g);
			Graphics2D g2d = (Graphics2D) g;
			g2d.setBackground(Color.BLUE);
			g2d.clearRect(0, 0, getWidth(), getHeight());
			g2d.drawImage(DrawingUtility.resizeImage(DrawingUtility.getImage("res/img/bgEmptyPanel1.png"), 1), null, 0, 0);
		}
	}
	public class EmptyPanel2 extends JPanel {
		public EmptyPanel2() {
			// TODO Auto-generated constructor stub
			setPreferredSize(new Dimension(300, 100));
			 setOpaque(false);
		}
		@Override
		protected void paintComponent(Graphics g) {
			// TODO Auto-generated method stub
			super.paintComponent(g);
			Graphics2D g2d = (Graphics2D) g;
			g2d.setBackground(Color.BLACK);
			g2d.clearRect(0, 0, getWidth(), getHeight());
			g2d.drawImage(DrawingUtility.getImage("res/img/bgEmptyPanel2.png"), null, 0, 0);
		}
	}
	public class EmptyPanel3 extends JPanel {
		public EmptyPanel3() {
			// TODO Auto-generated constructor stub
			setPreferredSize(new Dimension(300, 100));
			 setOpaque(false);
		}
		@Override
		protected void paintComponent(Graphics g) {
			// TODO Auto-generated method stub
			super.paintComponent(g);
			Graphics2D g2d = (Graphics2D) g;
			g2d.setBackground(Color.BLUE);
			g2d.clearRect(0, 0, getWidth(), getHeight());
			g2d.drawImage(DrawingUtility.getImage("res/img/bgEmptyPanel3.png"), null, 0, 0);
		}
	}
	
	
	public class NewGamePanel extends JPanel {
		public NewGamePanel() {
			// TODO Auto-generated constructor stub
			setPreferredSize(new Dimension(300, 100));
			 setOpaque(false);
		}
		@Override
		protected void paintComponent(Graphics g) {
			// TODO Auto-generated method stub
			super.paintComponent(g);
			Graphics2D g2d = (Graphics2D) g;
			g2d.setBackground(Color.GREEN);
			g2d.clearRect(0, 0, getWidth(), getHeight());
			g2d.drawImage(DrawingUtility.resizeImage(DrawingUtility.getImage("res/img/bgNewGame.png"), 2), null, 0, 0);
			g2d.drawImage(DrawingUtility.resizeButton(DrawingUtility.getImage("res/img/buttonNewGame.png"), 2), null, 40, 40);
		}
	}

	public class SettingPanel extends JPanel {
		@Override
		protected void paintComponent(Graphics g) {
			// TODO Auto-generated method stub
			super.paintComponent(g);
			Graphics2D g2d = (Graphics2D) g;
			g2d.setBackground(Color.YELLOW);
			g2d.clearRect(0, 0, getWidth(), getHeight());
			g2d.drawImage(DrawingUtility.getImage("res/img/bgSetting.png"), null, 0, 0);
			g2d.drawImage(DrawingUtility.resizeButton(DrawingUtility.getImage("res/img/buttonSetting.png"), 2), null, 40, 20);
		}
	}

	public class QuitPanel extends JPanel {
		@Override
		protected void paintComponent(Graphics g) {
			// TODO Auto-generated method stub
			super.paintComponent(g);
			Graphics2D g2d = (Graphics2D) g;
			g2d.setBackground(Color.RED);
			g2d.clearRect(0, 0, getWidth(), getHeight());
			g2d.drawImage(DrawingUtility.getImage("res/img/bgQuit.png"), null, 0, 0);
			g2d.drawImage(DrawingUtility.resizeButton(DrawingUtility.getImage("res/img/buttonQuit.png"), 2), null, 40, 0);
		}
	}

	public static void addItem(JPanel p, JComponent c, int x, int y, int w, int h, int align) {
		GridBagConstraints gc = new GridBagConstraints();
		gc.gridx = x;
		gc.gridy = y;
		gc.gridwidth = w;
		gc.gridheight = h;
		gc.anchor = align;
		gc.fill = GridBagConstraints.NONE;
		p.add(c, gc);
	}
//	public void paint(Graphics2D g){
//		super.draw(g);

//	}

	@Override
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;
		
		background.draw(g2d);
	}
}
