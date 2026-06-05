package io.github.some_example_name;

import com.sun.org.apache.xpath.internal.objects.XString;

public class Level {

    private String codiceDisinnesco;
    private String coloreDisinnesco;
    private boolean lampeggiante;
    private int luciAccese;
    private boolean attivo;
    private double tempo;

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


}
