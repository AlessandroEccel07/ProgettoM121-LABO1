package io.github.some_example_name;

import com.badlogic.gdx.graphics.Texture;

import java.util.Random;

public class Level1 extends Level {


    public Level1() {
        setTempo(500);
        setxIstruzioni(330);
        setyIstruzioni(50);
        setwIstruzioni(1034);
        sethIstruzioni(698);
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
                V=2;
            }
            if(!isLampeggiante()){
                setColoreDisinnesco("yellow");
                V=7;
            }
        }
        if(!(N%2==0)){
            if(isLampeggiante()){
                setColoreDisinnesco("blue");
                V=4;
            }
            if(!isLampeggiante()){
                setColoreDisinnesco("green");
                V=5;
            }
        }
        if(isLampeggiante()) {
            codice = (5000 + N)+V;
        }
        if(!isLampeggiante()) {
            codice = (5000 + N)-V;
        }

        String val= Integer.toString(codice);
        setCodiceDisinnesco(val);

        setAttivo(false);


    }
    public void loadIstruzioni() {
        setIstruzioni(new Texture("istruzioni1.png"));
    }
}
