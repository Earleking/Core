package Creations;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.Fixture;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;

/**
 * Created by Arek Fielding on 1/30/2017.
 */

public class Creations {
	private Body body;
	private Sprite sprite;
	private float x, y;
	private static FixtureDef fixtureDef;
	private static Fixture fixture;
	private int width, height;
	public Creations(World world, int x, int y, int height, int width, Color color) {
		this.x = x;
		this.y = y;
		//Color it
		Texture texture;
		Pixmap pmap = new Pixmap(width, height, Pixmap.Format.RGB565);
		pmap.setColor(color);
		this.width = width;
		this.height = height;
		pmap.fillRectangle(0, 0, width, height);
		texture = new Texture(pmap);
		texture.draw(pmap, 0, 0);
		sprite = new Sprite(texture);
		texture.dispose();
		//Create Body for physics
		BodyDef bodyDef = new BodyDef();
		bodyDef.type = BodyDef.BodyType.DynamicBody;
		bodyDef.position.set(x, y);
		body = world.createBody(bodyDef);
		body.createFixture(fixtureDef);

	}
	public Creations() {

	}
	public void createFixture(int categoryBits, int maskBits) {
		PolygonShape shape = new PolygonShape();
		shape.setAsBox(width, height);
		fixtureDef = new FixtureDef();
		fixtureDef.shape = shape;
		fixtureDef.density = .5f;
		fixtureDef.restitution = 0;
		fixtureDef.filter.groupIndex = 1;
		fixtureDef.filter.categoryBits = (short)categoryBits;
		fixtureDef.filter.maskBits = (short)maskBits;

	}


	public void draw(SpriteBatch batch) {
		batch.draw(sprite, x, y);
	}

	public void dispose() {

	}


}
