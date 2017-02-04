package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.World;

import java.util.ArrayList;

import Creations.Bullets;
import Creations.Creations;
import Creations.Enviro;

public class MyGdxGame extends Game {
	//General Creation
	private World world;
	private OrthographicCamera camera;
	private SpriteBatch batch;
	private BitmapFont font;
	//Masks
	private short PLAYER = 0x0000;
	private short GROUND = 0x0001;
	private short BULLET = 0x0002;
	//List
	private ArrayList<Bullets> bulletList;
	private ArrayList<Enviro> groundList;
	//Player
	private Creations playOne;
	private Creations playTwo;
	
	@Override
	public void create () {
		//World Begin
		world = new World(new Vector2(0, -10), true);
		camera = new OrthographicCamera(200, 130);
		batch = new SpriteBatch();
		font = new BitmapFont();
		//Initialize Lists
		bulletList = new ArrayList<Bullets>();
		groundList = new ArrayList<Enviro>();
		//Create Static Variables
		new Bullets(1, 1).createBulletTemplate();
		new Creations().createFixture(PLAYER, GROUND);

		//Creation Objects
		bulletList.add(new Bullets(1, 1));
		bulletList.add(new Bullets(1, 3));

		playOne = new Creations(world, 5, 5, 3, 3, Color.BLUE);
		playTwo = new Creations(world, 10, 10, 3, 3, Color.RED);
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.setProjectionMatrix(camera.combined);
		batch.begin();
		for(int i = 0; i < bulletList.size(); i ++) {
			bulletList.get(i).update(Gdx.graphics.getDeltaTime());
			bulletList.get(i).draw(batch);
			if(bulletList.get(i).delete()) {
				bulletList.remove(i);
			}
		}
		playOne.draw(batch);
		playTwo.draw(batch);
		font.draw(batch, "Hello", 0, 0);
		batch.end();
		camera.update();
		world.step(1/60, 6, 2);
	}


	@Override
	public void resize(int width, int height) {

	}

	@Override
	public void pause() {

	}

	@Override
	public void resume() {

	}


	@Override
	public void dispose() {
		world.dispose();
		font.dispose();
		batch.dispose();
	}

	void handleInput() {
		if(Gdx.input.isKeyPressed(Input.Keys.D)) {

		}
		if(Gdx.input.isKeyPressed(Input.Keys.A)) {

		}
		if(Gdx.input.isKeyJustPressed(Input.Keys.W)) {

		}
		if(Gdx.input.isKeyJustPressed(Input.Keys.SPACE)) {

		}
	}
}
