package com.ben.asteroids;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.ben.managers.GameInputProcessor;
import com.ben.managers.GameKeys;
import com.ben.managers.GameStateManager;

public class Asteroids implements ApplicationListener {

	public static int WIDTH;
	public static int HEIGHT;
	
	
	public static OrthographicCamera cam;
	
	private GameStateManager gsm;
	
	
	@Override
	public void create() {

		WIDTH = Gdx.graphics.getWidth();
		HEIGHT = Gdx.graphics.getHeight();
		
		cam = new OrthographicCamera(WIDTH,HEIGHT);
		// move the cam to the right point
		cam.translate(WIDTH/2, HEIGHT/2);
		cam.update();
		
		Gdx.input.setInputProcessor(new GameInputProcessor());
		
		gsm = new GameStateManager();
		
	}

	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void render() {

		// clear screen to black
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		
		gsm.update(Gdx.graphics.getDeltaTime());
		gsm.draw();
		
		GameKeys.update();
		
		
		
		
		
	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		
	}

	
	

		
	}
	
	
	
	


