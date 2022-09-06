package mapa;

import exceptions.PersonagemJaEstaNoMapaException;
import exceptions.PersonagemNaoEncontradoNoMapaException;
import exceptions.PosicaoOcupadaException;
import tiposPersonagens.Personagens;

public class Mapa {
    Personagens[] arrayPersonagens = new Personagens[10];

    public String exibir(){
        String mapaExibido = "|";
        for (int i = 0; i < 10; i++) {
            mapaExibido = mapaExibido.concat(this.arrayPersonagens[i] == null? " |":this.arrayPersonagens[i].toString() + "|");
        }
        return mapaExibido;

    }
    public void inserir(int posicao, Personagens personagem) throws PosicaoOcupadaException, PersonagemJaEstaNoMapaException{
        if (arrayPersonagens[posicao] != null){
            throw new PosicaoOcupadaException();
        }
        for (int i = 0; i < 10; i++){
            if (arrayPersonagens[i] == personagem){
                throw new PersonagemJaEstaNoMapaException();
            }
        }
        this.arrayPersonagens[posicao] = personagem;
    }
    public void apagaPersonagem(int posicao){
        this.arrayPersonagens[posicao] = null;

    }
    public int buscarPosicao(Personagens personagem) throws PersonagemNaoEncontradoNoMapaException {
        Integer indexPersonagem = null;
        for (int i = 0; i < 10; i++){
            if (arrayPersonagens[i] == personagem){
                indexPersonagem = i;
            }
        }
        if (indexPersonagem == null){
            throw new PersonagemNaoEncontradoNoMapaException();
        }
        return indexPersonagem;
    }
    public Personagens buscarCasa(int posicao){
        return arrayPersonagens[posicao];
    }
}
