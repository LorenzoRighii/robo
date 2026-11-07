package br.com.joaocarloslima.robo.controller;

import br.com.joaocarloslima.robo.model.Direcao;
import br.com.joaocarloslima.robo.model.Posicao;
import br.com.joaocarloslima.robo.model.Sala;

public class ZigueZague implements Rota{

    private Direcao horizontal = Direcao.DIREITA;
    private Direcao vertical = Direcao.CIMA;


    @Override
    public String getNome() {
        return "ZigueZague";
    }

    @Override
    public Direcao proximaDirecao(Sala sala, Posicao atual) {
        if (sala.livre(atual.mover(horizontal))){
            horizontal = (horizontal == Direcao.DIREITA) ? Direcao.ESQUERDA : Direcao.DIREITA;
            if (sala.livre(atual.mover(vertical))){
                vertical = (vertical == Direcao.BAIXO) ? Direcao.CIMA : Direcao.BAIXO;

            }
            return vertical;
        }
        return horizontal;


    }
}
