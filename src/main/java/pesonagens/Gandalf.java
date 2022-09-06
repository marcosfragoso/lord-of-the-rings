package pesonagens;

import comportamentos.Maia;
import tiposPersonagens.Mago;

public class Gandalf extends Mago implements Maia {

    public Gandalf() {
        super(2, 3,10,80);
        this.isSociedadeDoAnel = true;
    }
    @Override
    public String toString(){
        return "G";
    }
    @Override
    public Maia ressucitar() {
        if(0 >= this.constituicao){
            this.constituicao = 80;
        }
        return this;
    }

    @Override
    public String falar() {
        return "A Wizard is never late, nor is he early. He arrives precisely when he means to.";
    }
}
