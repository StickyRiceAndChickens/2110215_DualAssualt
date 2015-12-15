
package render;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class SettingScreen extends JPanel{
	
	public static int screenWidth=1280;
	public static int screenHeight=720;
	public static String resolution[] = {"1366x768","1280x720"};
	
	public SettingScreen() {
		this.setPreferredSize(new Dimension(SettingScreen.screenWidth, SettingScreen.screenHeight));
		this.setLayout(new BorderLayout());
		JPanel backPanel = new JPanel();
		this.add(backPanel, BorderLayout.SOUTH);
		JButton back = new JButton("BACK!");
		back.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				GameManager.goToTitle();
			}
		});
		backPanel.add(back, BorderLayout.WEST);
		JComboBox<String> res = new JComboBox<String>(resolution);
		res.setPreferredSize(new Dimension(150, 20));
		JPanel westPanel = new JPanel();
		this.add(westPanel, BorderLayout.WEST);
		westPanel.add(res, BorderLayout.CENTER);
		int SelectedRes = res.getSelectedIndex();
		if (SelectedRes == 0) {
			screenWidth = 1366;
			screenHeight = 768;
		} else {
			screenWidth = 1280;
			screenHeight = 720;
		}
		
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;
		g2d.setBackground(Color.white);
		g2d.drawImage(DrawingUtility.resizeImage(DrawingUtility.bgSettingScreen, 2, screenWidth, screenHeight), null, 0, 0);
		
	}
	
}

