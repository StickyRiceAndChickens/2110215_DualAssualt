package render;

import java.awt.Dimension;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

import logic.GameLogic;
import logic.Player;

public class GameManager {

	private static final int REFRESH_DELAY = 10;

	private static GameTitle titleScene;
	public static GameScreen gameScreen;
	private static GameWindow gameWindow;
	public static PlayerMenuScreen playerMenuScreen;
	private static SettingScreen settingScreen;
	private static JPanel nextScene = null;

	public static void runGame(GameLogic gameLogic) {
		titleScene = new GameTitle();

		playerMenuScreen = new PlayerMenuScreen();

		gameScreen = new GameScreen();

		gameWindow = new GameWindow(titleScene);
		
		settingScreen = new SettingScreen();

		while (true) {
			try {
				Thread.sleep(REFRESH_DELAY);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			gameWindow.getCurrentScene().repaint();
			if (gameWindow.getCurrentScene() instanceof GameScreen) {
				gameLogic.logicUpdate();

			}
			if (gameWindow.getCurrentScene() instanceof PlayerMenuScreen) {
				playerMenuScreen.update();
				InputUtility.postUpdate();
			}
			if (nextScene != null) {

				if (gameWindow.getCurrentScene() instanceof GameScreen)
					gameLogic.onExit();
				gameWindow.switchScene(nextScene);
				if (nextScene instanceof GameScreen) {
					AudioUtility.menuSong.stop();
					gameLogic.onStart();
					AudioUtility.playSound("game");
				}
				nextScene = null;
			}
		}
	}

	public static void goToTitle() {
		nextScene = titleScene;
	}

	public static void newGame() {
		nextScene = gameScreen;
	}

	public static void goToSetting() {
		nextScene = settingScreen;
	}

	public static void goToPlayerMenu() {
		nextScene = playerMenuScreen;
	}

	public static void resizeScreen() {
		gameWindow.setPreferredSize(new Dimension(SettingScreen.screenWidth, SettingScreen.screenHeight));
		gameWindow.setSize(new Dimension(SettingScreen.screenWidth, SettingScreen.screenHeight));

		titleScene.setPreferredSize(new Dimension(SettingScreen.screenWidth, SettingScreen.screenHeight));
		titleScene.setSize(new Dimension(SettingScreen.screenWidth, SettingScreen.screenHeight));

		gameScreen.setPreferredSize(new Dimension(SettingScreen.screenWidth, SettingScreen.screenHeight));
		gameScreen.setSize(new Dimension(SettingScreen.screenWidth, SettingScreen.screenHeight));

		playerMenuScreen.setPreferredSize(new Dimension(SettingScreen.screenWidth, SettingScreen.screenHeight));
		playerMenuScreen.setSize(new Dimension(SettingScreen.screenWidth, SettingScreen.screenHeight));

		settingScreen.setPreferredSize(new Dimension(SettingScreen.screenWidth, SettingScreen.screenHeight));
		settingScreen.setSize(new Dimension(SettingScreen.screenWidth, SettingScreen.screenHeight));

		titleScene.validate();
	}
}
