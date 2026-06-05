package io.github.some_example_name;

import java.util.Random;

public class Level1 extends Level {


    public Level1() {
        setTempo(500);
        genera();

        int valore=0;
        if (getLuciAccese()%2==0){
            if (isLampeggiante()){
                setColoreDisinnesco("red");
                valore= 5002;
            }else if (!isLampeggiante()){
                setColoreDisinnesco("yellow");
                valore= 4993;
            }
        } else if (getLuciAccese()%2!=0) {
            if (isLampeggiante()){
                setColoreDisinnesco("blue");
                valore= 5004;
            }else if (!isLampeggiante()){
                setColoreDisinnesco("green");
                valore= 4995;
            }
        }

        valore=valore+getLuciAccese();
        String val= Integer.toString(valore);
        setCodiceDisinnesco(val);

        setAttivo(false);
    }
    public void genera(){
        Random random = new Random();
        setLampeggiante(random.nextBoolean());

        setLuciAccese(random.nextInt(6));
    }
}
