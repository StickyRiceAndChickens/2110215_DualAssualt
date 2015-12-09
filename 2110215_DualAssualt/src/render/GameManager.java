package render;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

import logic.GameLogic;


public class GameManager {

	private static final int REFRESH_DELAY = 10;
	public static final int TICK_PER_SECONDS = 1000/REFRESH_DELAY;
	
	private static GameTitle titleScene;
	private static GameScreen gameScreen;
	private static GameWindow gameWindow;
	private static JPanel nextScene = null;
	
	public static void runGame(GameLogic gameLogic){
		titleScene = new GameTitle();
		
//		if(gameLogic instanceof RenderableHolder){
//			gameScreen = new GameScreen((RenderableHolder)gameLogic);
//		}else{
//			gameScreen = new GameScreen(new RenderableHolder() {
//				private List<IRenderable> emptyList = new ArrayList<IRenderable>(0);
//				@Override
//				public List<IRenderable> getSortedRenderableObject() {
//					return emptyList;
//				}
//			});
//		}
		
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
	
	public static void resizeScreen(){
		gameScreen.applyResize();
		gameWindow.setSize(ConfigurableOption.screenWidth, ConfigurableOption.screenHeight);
		titleScene.validate();
	}
}
