package br.com.joaocarloslima.robo.controller;

import br.com.joaocarloslima.robo.model.Direcao;
import br.com.joaocarloslima.robo.model.Posicao;
import br.com.joaocarloslima.robo.model.Sala;

import java.util.Random;

public class Ricochete implements Rota {


    @Override
    public String getNome() {
        return "Ricochete";
    }

    @Override
    public Direcao proximaDirecao(Sala sala, Posicao atual) {
        Direcao direcao = Direcao.DIREITA;
        Random random = new Random();

        if(!sala.livre(atual.mover(direcao))){
            Direcao[] direcoes = Direcao.values();
            direcao = direcoes[random.nextInt(direcoes.length)];
        }
        return direcao;
    }
}
