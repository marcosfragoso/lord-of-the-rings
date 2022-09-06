package pesonagens;

import comportamentos.Humano;
import tiposPersonagens.Guerreiro;

public class Boromir extends Guerreiro implements Humano {

    public Boromir() {
        super(7, 6,3,40);
        this.isSociedadeDoAnel = true;
    }

    @Override
    public String falar() {
        return "One does not simply walk into Mordor.";
    }
    @Override
    public String toString(){
        return "B";
    }

    @Override
    public int envelhecer() {
        this.constituicao = this.constituicao - 2;
        return this.constituicao;
    }
}
