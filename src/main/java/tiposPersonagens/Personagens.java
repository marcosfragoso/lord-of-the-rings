package tiposPersonagens;

import mapa.Mapa;

public abstract class Personagens {
    protected int forca;
    protected int agilidade;
    protected int inteligencia;
    protected int constituicao;
    protected boolean isSociedadeDoAnel;

    public Personagens(int forca, int agilidade, int inteligencia, int constituicao) {
        this.forca = forca;
        this.agilidade = agilidade;
        this.inteligencia = inteligencia;
        this.constituicao = constituicao;
        this.isSociedadeDoAnel = false;
    }


    public boolean isSociedadeDoAnel() {
        return isSociedadeDoAnel;
    }

    public int getConstituicao() {
        return constituicao;
    }

    public void setConstituicao(int constituicao) {
        this.constituicao = constituicao;
    }
}
