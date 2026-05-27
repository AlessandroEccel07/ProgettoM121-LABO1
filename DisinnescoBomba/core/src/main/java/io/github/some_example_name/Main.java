package io.github.some_example_name;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
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
    private Rectangle redRectanglebounds;
    private Rectangle yellowRectanglebounds;
    private Rectangle greenRectanglebounds;
    private Rectangle blueRectanglebounds;
    private String color = "null";
    private BitmapFont font;
    private double timer;
    private String inputCodice;
    private int countNumbers;
    private Texture RedButtonOn;
    private Texture RedButtonOff;
    private Texture explosion;
    private double redButtonTimer;
    private boolean redButtonisOn;


    @Override
    public void create() {
        shapeRenderer = new ShapeRenderer();
        batch = new SpriteBatch();
        background = new Texture("background.png");
        RedButtonOn = new Texture("RedButtonOn.png");
        RedButtonOff = new Texture("RedButtonOff.png");
        explosion = new Texture("explosionBomb.gif");
        dotBounds =new Rectangle(dotX, dotY,10,10);
        colorRectanglebounds =new Rectangle(484, 558, 250,245);
        redRectanglebounds=new Rectangle(491, 711, 95,77);
        yellowRectanglebounds=new Rectangle(491, 569, 93,67);
        greenRectanglebounds=new Rectangle(628, 566, 92,67);
        blueRectanglebounds=new Rectangle(628, 715, 94,75);
        font = new BitmapFont();
        font.setColor(Color.RED);
        font.getData().setScale(5f);
        timer=5000;
        redButtonTimer=2;
        redButtonisOn= false;
        inputCodice="";
        countNumbers=0;
    }

    @Override
    public void render() {
        if(!(timer<=0)){
            timer -= Gdx.graphics.getDeltaTime();
        }else timer=0;
        redButtonTimer-=Gdx.graphics.getDeltaTime();

            if(redButtonTimer>1){
                redButtonisOn=true;
            }
            if(redButtonTimer<1){
                redButtonisOn=false;
            }
            if(redButtonTimer<0){
                redButtonTimer=2;
            }

        float timers=Math.round(timer*100f)/100f;

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
        if(Gdx.input.isKeyPressed(Input.Keys.Q)) {
            System.out.println(dotX+","+ dotY);
        }
        if (Gdx.input.isKeyPressed(Input.Keys.R)){
            countNumbers=0;
            inputCodice="";
        }
        //KEYPAD
        if (countNumbers<=7) {
            if (Gdx.input.isKeyJustPressed(Input.Keys.NUM_1)) {
                inputCodice += "1";
                System.out.println(inputCodice);
                countNumbers++;
            }
            if (Gdx.input.isKeyJustPressed(Input.Keys.NUM_2)) {
                inputCodice += "2";
                countNumbers++;
            }
            if (Gdx.input.isKeyJustPressed(Input.Keys.NUM_3)) {
                inputCodice += "3";
                countNumbers++;
            }
            if (Gdx.input.isKeyJustPressed(Input.Keys.NUM_4)) {
                inputCodice += "4";
                countNumbers++;
            }
            if (Gdx.input.isKeyJustPressed(Input.Keys.NUM_5)) {
                inputCodice += "5";
                countNumbers++;
            }
            if (Gdx.input.isKeyJustPressed(Input.Keys.NUM_6)) {
                inputCodice += "6";
                countNumbers++;
            }
            if (Gdx.input.isKeyJustPressed(Input.Keys.NUM_7)) {
                inputCodice += "7";
                countNumbers++;
            }
            if (Gdx.input.isKeyJustPressed(Input.Keys.NUM_8)) {
                inputCodice += "8";
                countNumbers++;
            }
            if (Gdx.input.isKeyJustPressed(Input.Keys.NUM_9)) {
                inputCodice += "9";
                countNumbers++;
            }
            if (Gdx.input.isKeyJustPressed(Input.Keys.NUM_0)) {
                inputCodice += "0";
                countNumbers++;
            }
        }

        dotY += dotVelX* dt;
        dotX += dotVelY* dt;
//        if (!(dotBounds.overlaps(colorRectanglebounds))) {
//            dotX= 610;
//            dotY= 670;
//        }
        if (dotBounds.overlaps(redRectanglebounds)) {
            color="red";
        }
        if (dotBounds.overlaps(yellowRectanglebounds)) {
            color="yellow";
        }
        if (dotBounds.overlaps(greenRectanglebounds)) {
            color="green";
        }
        if (dotBounds.overlaps(blueRectanglebounds)) {
            color="blue";
        }
        if (!(dotBounds.overlaps(redRectanglebounds))||!(dotBounds.overlaps(yellowRectanglebounds))||!(dotBounds.overlaps(greenRectanglebounds))||!(dotBounds.overlaps(blueRectanglebounds))) {
            color="null";
        }

        dotBounds.setPosition(dotX, dotY);
        ScreenUtils.clear(0.15f, 0.15f, 0.2f, 1f);
        batch.begin();
        batch.draw(background, 0, 0);
        font.draw(batch, timers+"", 1025, 810);
        font.draw(batch, inputCodice, 450,307);
        if (redButtonisOn){
        batch.draw(RedButtonOn, 1015,162);
        }else {
            batch.draw(RedButtonOff, 1015, 162);
        }
        if(timer==0){
            batch.draw(explosion, 0, 0, 1681,919);
        }
        batch.end();
        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
        shapeRenderer.setColor(Color.WHITE);
        shapeRenderer.circle(dotX , dotY, 1);
        shapeRenderer.end();
        shapeRenderer.begin(ShapeRenderer.ShapeType.Line);
        shapeRenderer.setColor(Color.WHITE);
        shapeRenderer.rect(colorRectanglebounds.x , colorRectanglebounds.y, 250,245);
        shapeRenderer.rect(redRectanglebounds.x , redRectanglebounds.y, 95,77);
        shapeRenderer.rect(greenRectanglebounds.x , greenRectanglebounds.y, 92,67);
        shapeRenderer.rect(yellowRectanglebounds.x , yellowRectanglebounds.y, 93,67);
        shapeRenderer.rect(blueRectanglebounds.x , blueRectanglebounds.y, 94,75);
        shapeRenderer.end();
    }

    @Override
    public void dispose() {
        background.dispose();
        shapeRenderer.dispose();
        batch.dispose();

    }
}
