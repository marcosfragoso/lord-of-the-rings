package tiposPersonagens;

import mapa.Mapa;

public class Arqueiro extends Personagens{

    public Arqueiro(int forca, int agilidade, int inteligencia, int constituicao) {
        super(forca, agilidade, inteligencia, constituicao);
    }
    public void ataqueArqueiro(Personagens personagem, int posicao){
        personagem.setConstituicao(personagem.getConstituicao() - (posicao * this.agilidade));
    }


}
