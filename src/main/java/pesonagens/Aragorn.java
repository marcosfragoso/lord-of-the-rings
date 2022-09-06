package pesonagens;

import comportamentos.Humano;
import tiposPersonagens.Guerreiro;

public class Aragorn extends Guerreiro implements Humano {

    public Aragorn() {
        super(10, 7,6,60);
        this.isSociedadeDoAnel = true;
    }
    @Override
    public int envelhecer() {
        this.constituicao = this.constituicao - 1;
        return this.constituicao;
    }
    @Override
    public String toString(){
        return "A";
    }

    @Override
    public String falar() {
        return "A day may come when the courage of men fails… but it is not THIS day.";
    }

}
