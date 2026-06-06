package io.github.some_example_name;

import com.badlogic.gdx.graphics.Texture;
import com.sun.org.apache.xpath.internal.objects.XString;
import org.w3c.dom.Text;

public class Level {

    private String codiceDisinnesco;
    private String coloreDisinnesco;
    private boolean lampeggiante;
    private int luciAccese;
    private boolean attivo;
    private double tempo;
    private Texture istruzioni;
    private int xIstruzioni;
    private int yIstruzioni;
    private int wIstruzioni;
    private int hIstruzioni;


    public String getCodiceDisinnesco() {
        return codiceDisinnesco;
    }

    public void setCodiceDisinnesco(String codiceDisinnesco) {
        this.codiceDisinnesco = codiceDisinnesco;
    }

    public String getColoreDisinnesco() {
        return coloreDisinnesco;
    }

    public void setColoreDisinnesco(String coloreDisinnesco) {
        this.coloreDisinnesco = coloreDisinnesco;
    }

    public boolean isLampeggiante() {
        return lampeggiante;
    }

    public void setLampeggiante(boolean lampeggiante) {
        this.lampeggiante = lampeggiante;
    }

    public int getLuciAccese() {
        return luciAccese;
    }

    public void setLuciAccese(int luciAccese) {
        this.luciAccese = luciAccese;
    }

    public boolean isAttivo() {
        return attivo;
    }

    public void setAttivo(boolean attivo) {
        this.attivo = attivo;
    }

    public double getTempo(){return tempo;}

    public void setTempo(double tempo){this.tempo=tempo;}

    public Texture getIstruzioni(){return istruzioni;}

    public void setIstruzioni(Texture istruzioni){this.istruzioni=istruzioni;}

    public int getxIstruzioni(){return xIstruzioni;}

    public void setxIstruzioni(int xIstruzioni){this.xIstruzioni=xIstruzioni;}

    public int getyIstruzioni(){return yIstruzioni;}

    public void setyIstruzioni(int yIstruzioni){this.yIstruzioni=yIstruzioni;}

    public int getwIstruzioni(){return wIstruzioni;}

    public void setwIstruzioni(int wIstruzioni){this.wIstruzioni=wIstruzioni;}

    public int gethIstruzioni(){return hIstruzioni;}

    public void sethIstruzioni(int hIstruzioni){this.hIstruzioni=hIstruzioni;}






}
