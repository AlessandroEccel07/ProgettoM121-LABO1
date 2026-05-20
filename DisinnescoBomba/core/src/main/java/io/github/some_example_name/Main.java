package io.github.some_example_name;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.utils.ScreenUtils;

/**import javax.swing.*;
import java.awt.*;*/

/** {@link com.badlogic.gdx.ApplicationListener} implementation shared by all platforms. */
public class Main extends ApplicationAdapter {
    private SpriteBatch batch;
    private Texture background;
    private ShapeRenderer shapeRenderer;
    private float dotY= 670;
    private float dotX= 610;
    private float dotVelY=0;
    private float dotVelX=0;
    private Rectangle dotBounds;
    private Rectangle colorRectanglebounds;

    @Override
    public void create() {
        shapeRenderer = new ShapeRenderer();
        batch = new SpriteBatch();
        background = new Texture("background.png");
        dotBounds =new Rectangle(dotX, dotY,10,10);
        colorRectanglebounds =new Rectangle(484, 558, 250,245);
    }

    @Override
    public void render() {
        float dt = Gdx.graphics.getDeltaTime();
        dotVelX = 0;
        dotVelY = 0;
        if(Gdx.input.isKeyPressed(Input.Keys.UP)) {
            System.out.println("UP");
            dotVelX = 100;
        }
        if(Gdx.input.isKeyPressed(Input.Keys.DOWN)) {
            System.out.println("DOWN");
            dotVelX = -100;
        }
        if(Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
            System.out.println("RIGHT");
            dotVelY = 100;
        }
        if(Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
            System.out.println("LEFT");
            dotVelY = -100;
        }
        if(Gdx.input.isKeyPressed(Input.Keys.Q)) {
            System.out.println(dotX+","+ dotY);
        }
        dotY += dotVelX* dt;
        dotX += dotVelY* dt;
        if (dotBounds.overlaps(colorRectanglebounds)) {
            System.out.println("Collision");
        }
        dotBounds.setPosition(dotX, dotY);
        ScreenUtils.clear(0.15f, 0.15f, 0.2f, 1f);
        batch.begin();
        batch.draw(background, 0, 0);
        batch.end();
        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
        shapeRenderer.setColor(Color.WHITE);
        shapeRenderer.circle(dotX , dotY, 10);
        shapeRenderer.end();
        shapeRenderer.begin(ShapeRenderer.ShapeType.Line);
        shapeRenderer.setColor(Color.WHITE);
        shapeRenderer.rect(colorRectanglebounds.x , colorRectanglebounds.y, 250,245);
        shapeRenderer.end();
    }

    @Override
    public void dispose() {
        background.dispose();
        shapeRenderer.dispose();
        batch.dispose();

    }
}
