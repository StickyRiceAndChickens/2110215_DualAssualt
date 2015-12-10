package render;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class GameTitle extends JPanel {
	public GameTitle(){
		this.setLayout(new BorderLayout());
		//ใส่โลโก้หรือชื่อเกม
		JPanel topPanel=new JPanel();
		topPanel.setPreferredSize(new Dimension(800,680));
		JLabel titleName=new JLabel("Game Name");
		topPanel.add(titleName);
		this.add(topPanel,BorderLayout.NORTH);
		//ปุ่มเริ่มเล่น
		JPanel centerPanel = new JPanel();
		JButton playButton = new JButton("Play game");
		playButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		JButton SettingButton = new JButton("How to Play");
	
		SettingButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		centerPanel.add(playButton);
		centerPanel.add(SettingButton);
		this.add(centerPanel, BorderLayout.CENTER);
	}
}
