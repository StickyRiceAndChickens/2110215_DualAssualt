package render;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class GameTitle extends JPanel {
	public GameTitle(){
		this.setLayout(new BorderLayout());
		JPanel westPanel = new JPanel();
		westPanel.setLayout(new GridBagLayout());
		
		NewGamePanel newGamePanel = new NewGamePanel();
		SettingPanel settingPanel = new SettingPanel();
		QuitPanel quitPanel = new QuitPanel();
		
		this.add(westPanel, BorderLayout.WEST);
		
		addItem(westPanel, newGamePanel, 0, 8, 1, 1, GridBagConstraints.WEST);
		addItem(westPanel, settingPanel, 0, 9, 1, 1, GridBagConstraints.WEST);
		addItem(westPanel, quitPanel, 0, 10, 1, 1, GridBagConstraints.WEST);
	}
	
public class NewGamePanel extends JPanel {
	public void draw(Graphics2D g2d) {
		g2d.drawImage(DrawingUtility.getImage("res/img/buttonNewGame2.jpg"), null, 0, 0);
	}
}
public class SettingPanel extends JPanel {
	public void draw(Graphics2D g2d) {
		g2d.drawImage(DrawingUtility.getImage("res/img/buttonSetting2.jpg"), null, 0, 0);
	}
}
public class QuitPanel extends JPanel {
	public void draw(Graphics2D g2d) {
		g2d.drawImage(DrawingUtility.getImage("res/img/buttonQuit2.jpg"), null, 0, 0);
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
	
}
