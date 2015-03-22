package com.ben.managers;

import com.ben.gamestates.GameState;
import com.ben.gamestates.PlayState;

public class GameStateManager {

	
	// current game state
	private GameState gameState;
	
	public static final int MENU = 0;
	public static final int PLAY = 1337;
	
	
	public GameStateManager(){
		setState(PLAY);
	}
	
	public void setState(int state){
		if(gameState!= null) gameState.dispose();
		if(state == MENU){
			// switch to menu  state
			// gameState = new PlayState(this);
		}
		if(state == PLAY){
			gameState = new PlayState(this);
		}
		
	}
	
	public void update(float dt){
		gameState.update(dt);
	}
	
	public void draw(){
		gameState.draw();
	}
	
}
