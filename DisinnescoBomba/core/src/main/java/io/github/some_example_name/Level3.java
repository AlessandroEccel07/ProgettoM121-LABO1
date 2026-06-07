package io.github.some_example_name;

import com.badlogic.gdx.graphics.Texture;

import java.util.Random;

public class Level3 extends Level{
    public Level3(){
        setTempo(180);
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
        int N = getLuciAccese();
        int V=0;
        int Ropposto=0;
        int R=0;
        int A=0;
        int B=0;
        int C=0;
        int codice=0;

        if (isLampeggiante()){
            R= N *3;
        }
        if(!isLampeggiante()){
            R=N*2;
        }
        if(0<=R && R<=2){
            setColoreDisinnesco("red");
            V=2;
            Ropposto=6;
        }
        if(3<=R && R<=4){
            setColoreDisinnesco("blue");
            V=4;
            Ropposto=11;
        }
        if(5<=R && R<=6){
            setColoreDisinnesco("green");
            V=6;
            Ropposto=2;
        }
        if(7<=R && R<=11){
            setColoreDisinnesco("yellow");
            V=8;
            Ropposto=4;
        }
        A= N+V+Ropposto;

        if(isLampeggiante()){
            B=A * 3;
        }
        if(!isLampeggiante()){
            B=A*2;
        }
        C=7000+B;

        if("yellow".equals(getColoreDisinnesco())){
            codice=C+44;
        }
        if("red".equals(getColoreDisinnesco())){
            codice=C+11;
        }
        if("green".equals(getColoreDisinnesco())){
            codice=C+33;
        }
        if("blue".equals(getColoreDisinnesco())){
            codice=C+22;
        }
        String val= Integer.toString(codice);
        setCodiceDisinnesco(val);

        setAttivo(false);
    }
    public void loadIstruzioni() {
        setIstruzioni(new Texture("istruzioni3.png"));
    }
}
