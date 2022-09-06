package pesonagens;

import comportamentos.Anao;
import tiposPersonagens.Guerreiro;

public class Gimli extends Guerreiro implements Anao {
    private int contadorDeBeber;

    public Gimli() {
        super(9, 2,4,60);
        this.contadorDeBeber = 0;
        this.isSociedadeDoAnel = true;
    }
    @Override
    public String toString(){
        return "I";
    }

    @Override
    public void beber() {
        this.contadorDeBeber = this.contadorDeBeber + 1;
    }

    @Override
    public String falar() {
        if (this.contadorDeBeber >= 3){
            return "What did I say? He can't hold his liquor!";
        } else {
            return "Let them come. There is one Dwarf yet in Moria who still draws breath.";
        }
    }
}
