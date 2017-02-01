package Creations;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 * Created by Arek Fielding on 1/30/2017.
 */

public class Bullets {
	private static final int speed = 50;
	private static Texture texture;
	private float x, y;
	private float spawnTime = 3;
	public Bullets(int x, int y) {
		this.x = x;
		this.y = y;
	}
	public void createBulletTemplate() {
		Pixmap pmap = new Pixmap(1, 1, Pixmap.Format.RGB565);
		pmap.setColor(Color.BLUE);
		pmap.fillRectangle(0, 0, 1, 1);
		texture = new Texture(pmap);
		texture.draw(pmap, 0, 0);

	}
	public void update(float deltaTime) {
		this.x += speed * deltaTime;
		spawnTime -= deltaTime;
	}
	public void draw(SpriteBatch batch) {batch.draw(texture, this.x, this.y);
	}
	public boolean delete() {
		if(spawnTime > 0) {
			return false;
		}
		return true;

	}

}
