package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.World;

import java.util.ArrayList;

import Creations.Bullets;

public class MyGdxGame extends Game {
	//General Creation
	World world;
	OrthographicCamera camera;
	SpriteBatch batch;
	BitmapFont font;
	//Bullet List
	ArrayList<Bullets> bulletList;
	
	@Override
	public void create () {
		bulletList = new ArrayList<Bullets>();
		world = new World(new Vector2(0, -10), true);
		camera = new OrthographicCamera(50, 30);
		batch = new SpriteBatch();
		new Bullets(1, 1).createBulletTemplate();
		font = new BitmapFont();
		bulletList.add(new Bullets(1, 1));
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
		if(Gdx.input.isKeyJustPressed(Input.Keys.D)) {

		}
	}
}
