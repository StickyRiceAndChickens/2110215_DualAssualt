import logic.GameLogic;

import render.GameManager;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		GameLogic logic = new GameLogic();
		GameManager.runGame(logic);
	}

}
