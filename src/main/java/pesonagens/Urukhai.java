package pesonagens;

import comportamentos.Humano;
import comportamentos.Monstro;
import tiposPersonagens.Guerreiro;

public class Urukhai extends Guerreiro implements Monstro, Humano {

    public Urukhai() {
        super(8, 6,3,45);
    }
    @Override
    public String toString(){
        return "U";
    }
    @Override
    public String grunir() {
        return "Uuurrrrrr";
    }

    @Override
    public String falar() {
        return "Looks like meat's back on the menu boys!";
    }

    @Override
    public int envelhecer() {
        this.constituicao = this.constituicao - 2;
        return this.constituicao;
    }


}
