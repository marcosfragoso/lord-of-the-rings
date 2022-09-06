package mapa;

import exceptions.PersonagemJaEstaNoMapaException;
import exceptions.PosicaoOcupadaException;
import exceptions.SauronDominaOMundoException;
import tiposPersonagens.Arqueiro;
import tiposPersonagens.Guerreiro;
import tiposPersonagens.Mago;
import tiposPersonagens.Personagens;

public class Simulador {
    private final Mapa mapa;

    public Simulador(Mapa mapa) {
        this.mapa = mapa;
    }

    public void simular() throws PosicaoOcupadaException, PersonagemJaEstaNoMapaException, SauronDominaOMundoException {
        boolean isGuerraAcabou = false;

        while (!isGuerraAcabou) {
            for (int i = 0; i < 10; i++) {
                Personagens p = mapa.buscarCasa(i);
                if (p != null) {
                    if (p instanceof Guerreiro) {
                        i = jogadaGuerreiro(i, p);
                    }
                    if (p instanceof Mago) {
                        i = jogadaMago(i, p);
                    }
                    if (p instanceof Arqueiro) {
                        i = jogadaArqueiro(i, p);
                    }
                }
            }
            if ((mapa.buscarCasa(9) != null && mapa.buscarCasa(9).isSociedadeDoAnel())) {
                isGuerraAcabou = true;
            }
            if (isSociedadeMorta()) {
                throw new SauronDominaOMundoException();
            }
        }

    }

    private boolean isSociedadeMorta() {
        boolean temSociedadeViva = false;
        for (int i = 0; i < 10; i++) {
            if (mapa.buscarCasa(i) != null && mapa.buscarCasa(i).isSociedadeDoAnel()) temSociedadeViva = true;
        }
        return !temSociedadeViva;
    }

    private int jogadaArqueiro(int i, Personagens p) throws PosicaoOcupadaException, PersonagemJaEstaNoMapaException {
        if (p.isSociedadeDoAnel()) {
            if (i + 3 < 10 && (mapa.buscarCasa(i + 3) != null) && (!mapa.buscarCasa(i + 3).isSociedadeDoAnel())) {
                int distancia = 3;
                ((Arqueiro) p).ataqueArqueiro(mapa.buscarCasa(i + 3), distancia);
                if (mapa.buscarCasa(i + 3).getConstituicao() <= 0) {
                    mapa.apagaPersonagem(i + 3);
                }
            } else if (i + 2 < 10 && (mapa.buscarCasa(i + 2) != null) && (!mapa.buscarCasa(i + 2).isSociedadeDoAnel())) {
                int distancia = 2;
                ((Arqueiro) p).ataqueArqueiro(mapa.buscarCasa(i + 2), distancia);
                if (mapa.buscarCasa(i + 2).getConstituicao() <= 0) {
                    mapa.apagaPersonagem(i + 2);
                }
            } else if (i + 1 < 10 && (mapa.buscarCasa(i + 1) != null) && (!mapa.buscarCasa(i + 1).isSociedadeDoAnel())) {
                int distancia = 1;
                ((Arqueiro) p).ataqueArqueiro(mapa.buscarCasa(i + 1), distancia);
                if (mapa.buscarCasa(i + 1).getConstituicao() <= 0) {
                    mapa.apagaPersonagem(i + 1);
                }
            }

            if ((i + 2 < 10) && (mapa.buscarCasa(i + 1) == null) && (mapa.buscarCasa(i + 2) == null)) {
                mapa.apagaPersonagem(i);
                mapa.inserir(i + 2, p);
                i = i + 2;

            } else if ((i + 1 < 10) && (mapa.buscarCasa(i + 1) == null)) {
                mapa.apagaPersonagem(i);
                mapa.inserir(i + 1, p);
                i++;

            }
        }
        if (!p.isSociedadeDoAnel()) {
            if ((i - 3 >= 0) && (mapa.buscarCasa(i - 3) != null) && (mapa.buscarCasa(i - 3).isSociedadeDoAnel())) {
                int distancia = 3;
                ((Arqueiro) p).ataqueArqueiro(mapa.buscarCasa(i - 3), distancia);
                if (mapa.buscarCasa(i - 3).getConstituicao() <= 0) {
                    mapa.apagaPersonagem(i - 3);
                }
            } else if ((i - 2 >= 0) && (mapa.buscarCasa(i - 2) != null) && (mapa.buscarCasa(i - 2).isSociedadeDoAnel())) {
                int distancia = 2;
                ((Arqueiro) p).ataqueArqueiro(mapa.buscarCasa(i - 2), distancia);
                if (mapa.buscarCasa(i - 2).getConstituicao() <= 0) {
                    mapa.apagaPersonagem(i - 2);
                }
            } else if ((i - 1 >= 0) && (mapa.buscarCasa(i - 1) != null) && (mapa.buscarCasa(i - 1).isSociedadeDoAnel())) {
                int distancia = 1;
                ((Arqueiro) p).ataqueArqueiro(mapa.buscarCasa(i - 1), distancia);
                if (mapa.buscarCasa(i - 1).getConstituicao() <= 0) {
                    mapa.apagaPersonagem(i - 1);
                }

            }
            if ((mapa.buscarCasa(i - 1) == null) && (mapa.buscarCasa(i - 2) == null)) {

                mapa.apagaPersonagem(i);
                mapa.inserir(i - 2, p);
            } else if (mapa.buscarCasa(i - 1) == null) {
                mapa.apagaPersonagem(i);
                mapa.inserir(i - 1, p);

            }
        }
        return i;
    }

    private int jogadaMago(int i, Personagens p) throws PosicaoOcupadaException, PersonagemJaEstaNoMapaException {
        if (p.isSociedadeDoAnel()) {
            for (int c = i; c < 10; c++) {
                Personagens personagemAtacado = mapa.buscarCasa(c);
                if ((personagemAtacado != null) && (!personagemAtacado.isSociedadeDoAnel())) {
                    ((Mago) p).ataqueMago(personagemAtacado);
                    if (personagemAtacado.getConstituicao() <= 0) {
                        mapa.apagaPersonagem(c);
                    }
                }
            }
            if (isUnicoPersonagem(p)) {
                mapa.apagaPersonagem(i);
                mapa.inserir(9, p);
            }
        }
        if (!p.isSociedadeDoAnel()) {
            for (int c = i; c >= 0; c--) {
                Personagens personagemAtacado = mapa.buscarCasa(c);
                if ((personagemAtacado != null) && (personagemAtacado.isSociedadeDoAnel())) {
                    ((Mago) p).ataqueMago(personagemAtacado);
                    if (personagemAtacado.getConstituicao() <= 0) {
                        mapa.apagaPersonagem(c);
                    }
                }
            }
        }
        return i;
    }

    private boolean isUnicoPersonagem(Personagens p) {
        boolean isUnico = true;
        for (int i = 0; i < 10; i++) {
            if (mapa.buscarCasa(i) != null && mapa.buscarCasa(i) != p) isUnico = false;
        }
        return isUnico;
    }

    private int jogadaGuerreiro(int i, Personagens p) throws PosicaoOcupadaException, PersonagemJaEstaNoMapaException {
        if (p.isSociedadeDoAnel()) {
            if (i + 1 < 10) {
                Personagens inimigoAtacado = mapa.buscarCasa(i + 1);
                if (inimigoAtacado != null && !inimigoAtacado.isSociedadeDoAnel()) {
                    ((Guerreiro) p).ataqueGuerreiro(inimigoAtacado);
                    if (inimigoAtacado.getConstituicao() <= 0) {
                        mapa.apagaPersonagem(i + 1);
                    }
                }
                if (inimigoAtacado == null) {
                    mapa.apagaPersonagem(i);
                    mapa.inserir(i + 1, p);
                    i = i + 1;
                }
            }
            return i;
        }
        if (!p.isSociedadeDoAnel()) {
            if (i - 1 >= 0) {
                Personagens inimigoAtacado = mapa.buscarCasa(i - 1);
                if (inimigoAtacado != null && inimigoAtacado.isSociedadeDoAnel()) {
                    ((Guerreiro) p).ataqueGuerreiro(inimigoAtacado);
                    if (inimigoAtacado.getConstituicao() <= 0) {
                        mapa.apagaPersonagem(i - 1);
                    }
                }
                if (inimigoAtacado == null) {
                    mapa.apagaPersonagem(i);
                    mapa.inserir(i - 1, p);

                }
            }
        }
        return i;
    }
}
