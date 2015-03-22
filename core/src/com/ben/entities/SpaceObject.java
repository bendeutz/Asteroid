package com.ben.entities;

import com.ben.asteroids.Asteroids;

public class SpaceObject {

	protected float x;
	protected float y;
	
	protected float dx;
	protected float dy;
	
	protected float radians;
	protected float speed;
	protected float rotationSpeed;
	
	protected int width;
	protected int height;
	
	protected float[] shapex;
	protected float[] shapey;
	
	public float getX(){return x;}
	public float getY(){return y;}
	
	protected void wrap(){
		if(x<0) x = Asteroids.WIDTH;
		if(x>Asteroids.WIDTH) x = 0;
		if(y<0) y = Asteroids.HEIGHT;
		if(y>Asteroids.HEIGHT) y = 0;
	}
	
	
	
	
}
