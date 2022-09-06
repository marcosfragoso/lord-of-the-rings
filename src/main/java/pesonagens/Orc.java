package pesonagens;

import comportamentos.Monstro;
import tiposPersonagens.Guerreiro;

public class Orc extends Guerreiro implements Monstro {

    public Orc() {
        super(7, 4,1,30);
    }
    @Override
    public String toString(){
        return "O";
    }

    @Override
    public String grunir() {
        return "Arrrggghhh";
    }
}
