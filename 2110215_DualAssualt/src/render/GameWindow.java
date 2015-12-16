package render;

import javax.swing.JFrame;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class GameWindow extends JFrame{

	private JPanel currentScene;
	
	protected GameWindow(JPanel scene){
		super("Dual Assualt");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		
		this.currentScene = scene;
		getContentPane().add(currentScene);
		this.setUndecorated(true);
		pack();
		
		setVisible(true);
		
		this.setAlwaysOnTop(true);
		
		currentScene.requestFocus();
	}
	
	protected void switchScene(JPanel scene){
		getContentPane().remove(currentScene);
		this.currentScene = scene;
		getContentPane().add(currentScene);
		getContentPane().validate();
		pack();
		
		currentScene.requestFocus();
	}
	
	protected JPanel getCurrentScene(){
		return currentScene;
	}
	
}
