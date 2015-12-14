package render;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

import logic.GameLogic;


public class GameManager {

	private static final int REFRESH_DELAY = 20;
	
	
	private static GameTitle titleScene;
	private static GameScreen gameScreen;
	private static GameWindow gameWindow;
	private static SettingScreen settingScreen;
	private static PlayerMenuScreen playerMenuScreen;
	private static JPanel nextScene = null;
	
	public static void runGame(GameLogic gameLogic){
		titleScene = new GameTitle();
		

		gameScreen = new GameScreen();
		
		gameWindow = new GameWindow(titleScene);
		
		while(true){
			try {
				Thread.sleep(REFRESH_DELAY);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			gameWindow.getCurrentScene().repaint();
			if(gameWindow.getCurrentScene() instanceof GameScreen){
				gameLogic.logicUpdate();
				InputUtility.postUpdate();
			}
			if(nextScene != null){
				if(gameWindow.getCurrentScene() instanceof GameScreen)
					gameLogic.onExit();
				gameWindow.switchScene(nextScene);
				if(nextScene instanceof GameScreen)
					gameLogic.onStart();
				nextScene = null;
			}
		}
	}
	
	public static void goToTitle(){
		nextScene = titleScene;
	}
	
	public static void newGame(){
		nextScene = gameScreen;
	}
	public static void goToSetting(){
		nextScene = settingScreen;
	}
	public static void goToPlayerMenu(){
		nextScene = playerMenuScreen;
	}
	
	public static void resizeScreen(){
		gameWindow.setSize(SettingScreen.screenWidth, SettingScreen.screenHeight);
		titleScene.validate();
	}
}
