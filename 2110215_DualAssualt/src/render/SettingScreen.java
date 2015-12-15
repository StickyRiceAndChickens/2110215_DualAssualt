
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
public class SettingScreen extends JPanel {

	public static int screenWidth = 1280;
	public static int screenHeight = 720;
	public static String resolution[] = { "1280x720", "1366x768" };

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
		westPanel.add(apply);

	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;
		g2d.setBackground(Color.white);
		g2d.drawImage(DrawingUtility.resizeImage(DrawingUtility.bgSettingScreen, 2, screenWidth, screenHeight), null, 0,
				0);

	}

}
