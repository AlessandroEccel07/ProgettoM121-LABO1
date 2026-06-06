package io.github.some_example_name;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
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
    private Rectangle livellofacilebounds;
    private Rectangle livellomediobounds;
    private Rectangle livellodifficilebounds;
    private Rectangle istruzioniFolderBounds;
    private Rectangle istruzioniBounds;
    private Circle stopButton;
    private String color = "null";
    private BitmapFont font;
    private double timer;
    private String inputCodice;
    private int countNumbers;
    private Texture RedButtonOn;
    private Texture RedButtonOff;
    private Texture explosion;
    private Texture menuBackground;
    private Texture istruzioniFolder;
    private Texture winScreen;
    private double redButtonTimer;
    private boolean redButtonisOn;
    private boolean gameover;
    private boolean istruzioniOn;
    private boolean win;
    private Sound bombDefuse;
    private Music menuMusic;
    private Music winMusic;
    private Music bombTick;
    private Sound explosionFast;
    public boolean wasgameover;
    private float dissolvenza;
    private boolean getTempo;
    Level1 level1_1 = new Level1();
    Level2 level2_1 = new Level2();
    Level3 level3_1 = new Level3();
    private Level level;

    @Override
    public void create() {
        shapeRenderer = new ShapeRenderer();
        batch = new SpriteBatch();
        background = new Texture("background.png");
        menuBackground = new Texture("menuBackground.png");
        RedButtonOn = new Texture("RedButtonOn.png");
        RedButtonOff = new Texture("RedButtonOff.png");
        explosion = new Texture("BombaEsplosa.png");
        istruzioniFolder = new Texture("istruzioniFolder.png");
        winScreen = new Texture("BombaDisinnescata.png");
        dotBounds =new Rectangle(dotX, dotY,10,10);
        colorRectanglebounds =new Rectangle(484, 558, 250,245);
        redRectanglebounds=new Rectangle(491, 711, 95,77);
        yellowRectanglebounds=new Rectangle(491, 569, 93,67);
        greenRectanglebounds=new Rectangle(628, 566, 92,67);
        blueRectanglebounds=new Rectangle(628, 715, 94,75);
        livellofacilebounds= new Rectangle(320,140,300,185);
        livellomediobounds= new Rectangle(680, 140, 300,185 );
        livellodifficilebounds= new Rectangle(1050, 140, 300,185 );
        istruzioniFolderBounds= new Rectangle(-10, 100,160,600 );
        stopButton= new Circle(1148,615,55);
        font = new BitmapFont();
        font.setColor(Color.RED);
        font.getData().setScale(5f);
        timer=0;
        redButtonTimer=2;
        redButtonisOn= false;
        inputCodice="";
        countNumbers=0;
        gameover=false;
        istruzioniOn=false;
        win=false;
        wasgameover= false;
        dissolvenza= 1f;
        level=null;


        bombDefuse=Gdx.audio.newSound(Gdx.files.internal("bombDefuse.mp3"));
        explosionFast=Gdx.audio.newSound(Gdx.files.internal("explosionFast.mp3"));
        menuMusic=Gdx.audio.newMusic(Gdx.files.internal("menuMusic.mp3"));
        winMusic=Gdx.audio.newMusic(Gdx.files.internal("winMusic.mp3"));
        bombTick=Gdx.audio.newMusic(Gdx.files.internal("bombTick.mp3"));

        bombTick.setLooping(true);
        menuMusic.setLooping(true);
        menuMusic.setVolume(0.3f);
        getTempo=false;

    }

    @Override
    public void render() {

        float mouseX = Gdx.input.getX();
        float mouseY = Gdx.graphics.getHeight()- Gdx.input.getY();
        if(level1_1.isAttivo()==false&&level2_1.isAttivo()==false&&level3_1.isAttivo()==false){
            dissolvenza=1f;
            menuMusic.play();
            winMusic.stop();
            win=false;
            gameover=false;
            countNumbers=0;
            batch.begin();
            batch.draw(menuBackground,0,0, 1681,919);
            if(livellofacilebounds.contains(mouseX,mouseY)&&Gdx.input.justTouched()){
                level=level1_1;
                istruzioniBounds= new Rectangle(level1_1.getxIstruzioni(), level1_1.getyIstruzioni(),level1_1.getwIstruzioni() , level1_1.gethIstruzioni() );
                level1_1.loadIstruzioni();
                level1_1.setAttivo(true);
                timer= level1_1.getTempo();
                bombTick.play();
            }
            if(livellomediobounds.contains(mouseX,mouseY)&&Gdx.input.justTouched()){
                level=level2_1;
                istruzioniBounds= new Rectangle(level2_1.getxIstruzioni(), level2_1.getyIstruzioni(),level2_1.getwIstruzioni() , level2_1.gethIstruzioni() );
                level2_1.loadIstruzioni();
                level2_1.setAttivo(true);
                timer= level2_1.getTempo();
                bombTick.play();
            }
            if(livellodifficilebounds.contains(mouseX,mouseY)&&Gdx.input.justTouched()){
                level=level3_1;
                istruzioniBounds= new Rectangle(level3_1.getxIstruzioni(), level3_1.getyIstruzioni(),level3_1.getwIstruzioni() , level3_1.gethIstruzioni() );
                level3_1.loadIstruzioni();
                level3_1.setAttivo(true);
                timer= level3_1.getTempo();
                bombTick.play();
            }


            batch.end();
            shapeRenderer.begin(ShapeRenderer.ShapeType.Line);
            shapeRenderer.setColor(Color.YELLOW);
            shapeRenderer.rect(livellofacilebounds.x , livellofacilebounds.y, 300,185);
            shapeRenderer.rect(livellodifficilebounds.x , livellodifficilebounds.y, 300,185);
            shapeRenderer.rect(livellomediobounds.x , livellomediobounds.y, 300,185);
            shapeRenderer.end();

        }else{
        if(!getTempo) {
            timer = level.getTempo();
            getTempo=true;
        }
        menuMusic.stop();
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
        if (Gdx.input.isKeyPressed(Input.Keys.BACKSPACE)){
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

        //LOGICA GIOCO
            if(level.isAttivo()&&!win&&!gameover){
                if(!istruzioniOn&&istruzioniFolderBounds.contains(mouseX,mouseY)&&Gdx.input.justTouched()){
                    istruzioniOn=true;
                }
                else if(istruzioniOn&&Gdx.input.justTouched()&&!istruzioniBounds.contains(mouseX,mouseY)){
                    istruzioniOn=false;

                }
                if(stopButton.contains(mouseX,mouseY)&&Gdx.input.justTouched()){
                    if(inputCodice.equals(level.getCodiceDisinnesco())&&color.equals(level.getColoreDisinnesco())){
                        bombDefuse.play();
                        win=true;
                        bombTick.stop();
                        winMusic.play();
                    }else{
                        explosionFast.play();
                        bombTick.stop();
                        gameover=true;
                    }
                }
            }
            if (!wasgameover &&timer==0){
                gameover = true;
                bombTick.stop();
                explosionFast.play();

            }
            wasgameover= gameover;

        dotY += dotVelX* dt;
        dotX += dotVelY* dt;
        if (!(dotBounds.overlaps(colorRectanglebounds))) {
            dotX= 610;
            dotY= 670;
        }
        if (dotBounds.overlaps(redRectanglebounds)) {
            color="red";
        }
        else if (dotBounds.overlaps(yellowRectanglebounds)) {
            color="yellow";
        }
        else if (dotBounds.overlaps(greenRectanglebounds)) {
            color="green";
        }
        else if (dotBounds.overlaps(blueRectanglebounds)) {
            color="blue";
        }else{color="null";}




        dotBounds.setPosition(dotX, dotY);
        ScreenUtils.clear(0.15f, 0.15f, 0.2f, 1f);
        batch.begin();
        batch.draw(background, 0, 0);
        font.draw(batch, timers+"", 1025, 810);
        font.draw(batch, inputCodice, 450,307);
        batch.draw(istruzioniFolder, -10, 100,400,600 );
        if(istruzioniOn){
            batch.draw(level.getIstruzioni(), level.getxIstruzioni(),level.getyIstruzioni(), level.getwIstruzioni() , level.gethIstruzioni());
        }
        if(!istruzioniOn) {
            if (level.isLampeggiante()) {
                if (redButtonisOn) {
                    batch.draw(RedButtonOn, 1015, 162);
                } else {
                    batch.draw(RedButtonOff, 1015, 162);
                }
            }
                if (level.getLuciAccese() == 1) {
                    batch.draw(RedButtonOn, 895, 520, 65, 65);
                }
                if(level.getLuciAccese()==2){
                    batch.draw(RedButtonOn, 895, 520,65,65);
                    batch.draw(RedButtonOn, 895, 587,65,65);
                }
                if(level.getLuciAccese()==3){
                    batch.draw(RedButtonOn, 895, 520,65,65);
                    batch.draw(RedButtonOn, 895, 587,65,65);
                    batch.draw(RedButtonOn, 895, 654,65,65);
                }
                if(level.getLuciAccese()==4){
                    batch.draw(RedButtonOn, 895, 520,65,65);
                    batch.draw(RedButtonOn, 895, 587,65,65);
                    batch.draw(RedButtonOn, 895, 654,65,65);
                    batch.draw(RedButtonOn, 895, 721,65,65);
                }
                if(level.getLuciAccese()==5){
                    batch.draw(RedButtonOn, 895, 520,65,65);
                    batch.draw(RedButtonOn, 895, 587,65,65);
                    batch.draw(RedButtonOn, 895, 654,65,65);
                    batch.draw(RedButtonOn, 895, 721,65,65);
                    batch.draw(RedButtonOn, 895, 788,65,65);
                }

        }

        if(win||gameover){
            if(gameover){

                batch.draw(explosion, 0, 0, 1681,919);
            }
            if(win) {
                batch.draw(winScreen, 0, 0, 1681, 919);
            }
            level1_1.genera();
            level2_1.genera();
            level3_1.genera();

            dotY=670;
            dotX=610;
            inputCodice="";
            if(Gdx.input.isKeyJustPressed(Input.Keys.SPACE)){
                level.setAttivo(false);
                explosionFast.stop();
                bombDefuse.stop();
                countNumbers=0;
            }
        }

        batch.end();
        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
        shapeRenderer.setColor(Color.WHITE);
        if(istruzioniOn || win || gameover) {
            shapeRenderer.circle(dotX, dotY, 0);
        }
        else {
            shapeRenderer.circle(dotX, dotY, 10);
        }
        if(gameover){
            Gdx.gl.glEnable(GL20.GL_BLEND);
            shapeRenderer.setColor(1f,1f,1f,dissolvenza);
            shapeRenderer.rect(0,0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight() );
            dissolvenza-= Gdx.graphics.getDeltaTime()*0.1f;
            if(dissolvenza<=0f){
                dissolvenza=0f;
            }

        }


        shapeRenderer.end();
        shapeRenderer.begin(ShapeRenderer.ShapeType.Line);
        shapeRenderer.setColor(Color.WHITE);
//        shapeRenderer.rect(istruzioniFolderBounds.x, istruzioniFolderBounds.y, 160,600);
//        shapeRenderer.rect(istruzioniBounds.x, istruzioniBounds.y, istruzioni.getWidth(),istruzioni.getHeight());
//        shapeRenderer.rect(colorRectanglebounds.x , colorRectanglebounds.y, 250,245);
//        shapeRenderer.rect(redRectanglebounds.x , redRectanglebounds.y, 95,77);
//        shapeRenderer.rect(greenRectanglebounds.x , greenRectanglebounds.y, 92,67);
//        shapeRenderer.rect(yellowRectanglebounds.x , yellowRectanglebounds.y, 93,67);
//        shapeRenderer.rect(blueRectanglebounds.x , blueRectanglebounds.y, 94,75);
//        shapeRenderer.circle(stopButton.x, stopButton.y, 55);
        shapeRenderer.end();}
    }

    @Override
    public void dispose() {
        background.dispose();
        shapeRenderer.dispose();
        explosionFast.dispose();
        batch.dispose();

    }
}
