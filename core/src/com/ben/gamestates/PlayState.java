package com.ben.gamestates;

import java.util.ArrayList;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.MathUtils;
import com.ben.asteroids.Asteroids;
import com.ben.entities.Asteroid;
import com.ben.entities.Bullet;
import com.ben.entities.Player;
import com.ben.managers.GameKeys;
import com.ben.managers.GameStateManager;

public class PlayState extends GameState {
	
	private ShapeRenderer sr;
	
	private Player player;
	private ArrayList<Bullet> bullets;
	private ArrayList<Asteroid> asteroids;
	
	private int level;
	private int totalAsteroids;
	private int numAsteroidsLeft;

	public PlayState(GameStateManager gsm){
		super(gsm);
	}

	@Override
	public void init() {
		
		sr = new ShapeRenderer();
		
		bullets = new ArrayList<Bullet>();
		
		player = new Player(bullets);
		
		asteroids = new ArrayList<Asteroid>();
		asteroids.add(new Asteroid(100,100,Asteroid.LARGE));
		asteroids.add(new Asteroid(200,100,Asteroid.MEDIUM));
		asteroids.add(new Asteroid(300,100,Asteroid.SMALL));
		
		level = 1;
		spawnAsteroids();
		
	}
	
	private void spawnAsteroids(){
		
		asteroids.clear();
		
		int numToSpawn = 4 + level-1;
		totalAsteroids = numToSpawn * 7;
		numAsteroidsLeft = totalAsteroids;
		
		for(int i=0; i<numToSpawn;i++){
			
			float x = MathUtils.random(Asteroids.WIDTH);
			float y = MathUtils.random(Asteroids.HEIGHT);
			
			float dx = x - player.getX();
			float dy = y - player.getY();
			float dist = (float) Math.sqrt(dx*dx + dy*dy);
			
			while(dist < 100){
				x = MathUtils.random(Asteroids.WIDTH);
				y = MathUtils.random(Asteroids.HEIGHT);
				dx = x - player.getX();
				dy = y - player.getY();
				dist = (float) Math.sqrt(dx*dx + dy*dy);
			}
			
			asteroids.add(new Asteroid(x,y,Asteroid.LARGE));
			
		}
		
	}

	@Override
	public void update(float dt) {
		
		// user input
		handleInput();
		
		// update player
		player.update(dt);
		
		
		// update player bullets
		for(int i=0; i<bullets.size();i++){
			bullets.get(i).update(dt);
			if(bullets.get(i).shouldRemove()){
				bullets.remove(i);
				i--;
			}
		}
		
		// update asteroids
		for(int i=0; i < asteroids.size(); i++){
			asteroids.get(i).update(dt);
			if(asteroids.get(i).shouldRemove()){
				asteroids.remove(i);
				i--;
			}
		}
		
	}

	@Override
	public void draw() {
		player.draw(sr);
		
		for(int i=0;i<bullets.size();i++){
			bullets.get(i).draw(sr);
		}
		
		for(int i=0;i<asteroids.size();i++){
			asteroids.get(i).draw(sr);
		}
	}

	@Override
	public void handleInput() {
		player.setLeft(GameKeys.isDown(GameKeys.LEFT));
		player.setRight(GameKeys.isDown(GameKeys.RIGHT));
		player.setUp(GameKeys.isDown(GameKeys.UP));
		if(GameKeys.isPressed(GameKeys.SPACE)){
			player.shoot();
		}
	}

	@Override
	public void dispose() {
		
	}
	
}
