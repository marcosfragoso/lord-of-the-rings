package pesonagens;

import comportamentos.Maia;
import tiposPersonagens.Mago;

public class Saruman extends Mago implements Maia {

    public Saruman() {
        super(2, 2,9,70);
    }
    @Override
    public String toString(){
        return "S";
    }

    @Override
    public Maia ressucitar() {
        return null;
    }

    @Override
    public String falar() {
        return "Against the power of Mordor there can be no victory.";
    }
}
