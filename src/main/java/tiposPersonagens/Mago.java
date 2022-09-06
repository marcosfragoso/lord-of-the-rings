package tiposPersonagens;

import mapa.Mapa;

public class Mago extends Personagens{

    public Mago(int forca, int agilidade, int inteligencia, int constituicao) {
        super(forca, agilidade, inteligencia, constituicao);
    }
    public void ataqueMago(Personagens personagem){
        personagem.setConstituicao(personagem.getConstituicao() - this.inteligencia);
    }

}
