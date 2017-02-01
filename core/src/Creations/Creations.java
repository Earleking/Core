package Creations;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;

/**
 * Created by Arek Fielding on 1/30/2017.
 */

public class Creations {
	private Body body;
	private Sprite sprite;
	private float x, y;
	public Creations(int x, int y, int height, int width, Color color, int catagoryBits, int maskBits) {
		//Color it
		Texture texture;
		Pixmap pmap = new Pixmap(width, height, Pixmap.Format.RGB565);
		pmap.setColor(Color.BLUE);
		pmap.fillRectangle(0, 0, width, height);
		texture = new Texture(pmap);
		texture.draw(pmap, 0, 0);
		sprite = new Sprite(texture);
		texture.dispose();
		//Create Body for physics
		BodyDef bodyDef = new BodyDef();
		bodyDef.type = BodyDef.BodyType.DynamicBody;
		bodyDef.position.x = x;
		createFixture(height, width, catagoryBits, maskBits);
	}
	private void createFixture(int height, int width, int catagoryBits, int maskBits) {
		FixtureDef fixtureDef = new FixtureDef();
		PolygonShape shape = new PolygonShape();
		shape.setAsBox(width, height);
		fixtureDef.restitution = 0.1f;
		fixtureDef.friction = 1f;
		fixtureDef.density = 0.5f;
		fixtureDef.filter.groupIndex = 1;
		fixtureDef.filter.categoryBits = (short)catagoryBits;
		fixtureDef.filter.maskBits = (short)maskBits;

	}

	public void draw(SpriteBatch batch) {
		batch.draw(sprite, x, y);
	}

}
