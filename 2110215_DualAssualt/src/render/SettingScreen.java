
package render;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class SettingScreen extends JPanel {

	public static int screenWidth = 1280;
	public static int screenHeight = 720;
	public static String resolution[] = { "1280x720", "1366x768" };

	public SettingScreen() {
		this.setPreferredSize(new Dimension(SettingScreen.screenWidth, SettingScreen.screenHeight));
		this.setLayout(new BorderLayout());
		
		JPanel topPanel = new JPanel();
		KeyPanel centerPanel = new KeyPanel();
		JPanel bottomPanel = new JPanel();
		
		this.add(topPanel,BorderLayout.NORTH);
		this.add(centerPanel,BorderLayout.CENTER);
		this.add(bottomPanel,BorderLayout.SOUTH);
		
		
		JButton back = new JButton("BACK!");
		back.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				GameManager.goToTitle();
			}
		});
		
		JComboBox<String> res = new JComboBox<String>(resolution);
		res.setPreferredSize(new Dimension(150, 20));

		topPanel.add(res);
		

		JButton apply = new JButton("Apply");
		apply.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (res.getSelectedIndex() == 1) {
					screenWidth = 1366;
					screenHeight = 768;

				} else if (res.getSelectedIndex() == 0) {
					screenWidth = 1280;
					screenHeight = 720;
				}
				GameManager.resizeScreen();
				
			}
		});
		topPanel.add(apply);
		bottomPanel.add(back);

	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;
		g2d.setBackground(Color.white);
		g2d.drawImage(DrawingUtility.resizeImage(DrawingUtility.bgSettingScreen, 2, screenWidth, screenHeight), null, 0,
				0);

	}
	
	public class KeyPanel extends JPanel {
		public KeyPanel() {
			JButton p1k1 = new JButton("LEFT");
			p1k1.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent arg0) {
					// TODO Auto-generated method stub
					JFrame frame = new JFrame();
					frame.setPreferredSize(new Dimension(100,100));
					frame.setVisible(true);
				}
			});
//			this.add(p1k1);
		}
		
		protected void paintComponent(Graphics g) {
			// TODO Auto-generated method stub
			super.paintComponent(g);
			Graphics2D g2d = (Graphics2D) g;
			g2d.setBackground(Color.BLUE);
			g2d.clearRect(0, 0, getWidth(), getHeight());
			g2d.drawImage(DrawingUtility.resizeImage(DrawingUtility.bgSettingScreen, 2, this.getWidth(), this.getHeight()),null,0,0);
		}
	}

}
