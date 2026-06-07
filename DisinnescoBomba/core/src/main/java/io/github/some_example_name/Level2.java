package io.github.some_example_name;

import com.badlogic.gdx.graphics.Texture;

import java.util.Random;

public class Level2 extends Level {

    public Level2(){
        setTempo(300);
        setxIstruzioni(330);
        setyIstruzioni(10);
        setwIstruzioni(614);
        sethIstruzioni(900);
        setCompletato(false);
        genera();

    }
    public void genera(){
        Random random = new Random();
        setLampeggiante(random.nextBoolean());

        setLuciAccese(random.nextInt(6));
        int N=getLuciAccese();
        int V=0;
        int codice=0;
        if(N%2==0){
            if(isLampeggiante()){
                setColoreDisinnesco("red");
                V=3;
            }
            if(!isLampeggiante()){
                setColoreDisinnesco("yellow");
                V=6;
            }
        }
        if(!(N%2==0)){
            if(isLampeggiante()){
                setColoreDisinnesco("blue");
                V=1;
            }
            if(!isLampeggiante()){
                setColoreDisinnesco("green");
                V=4;
            }
        }
        if(isLampeggiante()) {
            codice = (5000 + N)*2+V;
        }
        if(!isLampeggiante()) {
            codice = (5000 + N)*3+V;
        }

        String val= Integer.toString(codice);
        setCodiceDisinnesco(val);

        setAttivo(false);
    }
    public void loadIstruzioni() {
        setIstruzioni(new Texture("istruzioni2.png"));
    }
}
