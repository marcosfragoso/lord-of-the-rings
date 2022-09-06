package tiposPersonagens;


public class Guerreiro extends Personagens{

    public Guerreiro(int forca, int agilidade, int inteligencia, int constituicao) {
        super(forca, agilidade, inteligencia, constituicao);
    }
    public void ataqueGuerreiro(Personagens personagem){
        personagem.setConstituicao(personagem.getConstituicao() - (2 * this.forca));
    }
}
