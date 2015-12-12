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

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;



@SuppressWarnings("serial")
public class GameTitle extends JPanel {
	GameBackground background;
	public GameTitle() {
		this.setPreferredSize(new Dimension(SettingScreen.screenWidth, SettingScreen.screenWidth));
		this.setLayout(new BorderLayout());
		JPanel westPanel = new JPanel();
		westPanel.setLayout(new GridLayout(6,1));
		
		westPanel.setPreferredSize(new Dimension(300, 500));
		JPanel emptyPanel = new JPanel();
		emptyPanel.setPreferredSize(new Dimension(300, 200));
		westPanel.add(emptyPanel);
		emptyPanel = new JPanel();
		westPanel.add(emptyPanel);
		emptyPanel = new JPanel();
		westPanel.add(emptyPanel);
		 background= new GameBackground();
		
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
			g2d.drawImage(DrawingUtility.getImage("res/img/buttonNewGame.png"), null, 0, 0);
		}
	}

	public class SettingPanel extends JPanel {
		@Override
		protected void paintComponent(Graphics g) {
			// TODO Auto-generated method stub
			super.paintComponent(g);
			Graphics2D g2d = (Graphics2D) g;
			g2d.drawImage(DrawingUtility.getImage("res/img/buttonSetting.png"), null, 0, 0);
		}
	}

	public class QuitPanel extends JPanel {
		@Override
		protected void paintComponent(Graphics g) {
			// TODO Auto-generated method stub
			super.paintComponent(g);
			Graphics2D g2d = (Graphics2D) g;
			g2d.drawImage(DrawingUtility.getImage("res/img/buttonQuit.png"), null, 0, 0);
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
		
		background.draw(g2d);;
	}
}
