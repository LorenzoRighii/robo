package br.com.joaocarloslima.robo.controller;

import br.com.joaocarloslima.robo.model.Direcao;
import br.com.joaocarloslima.robo.model.Posicao;
import br.com.joaocarloslima.robo.model.Robo;
import br.com.joaocarloslima.robo.model.Sala;

import java.util.Random;

public class Aleatoria implements Rota {


    public Aleatoria() {
    }

    @Override
    public String getNome() {
        return "Robo";
    }

    @Override
    public Direcao proximaDirecao(Sala sala, Posicao atual) {
        Direcao[] direcaos = Direcao.values();
        int aleatorio = new Random().nextInt(direcaos.length);

        return direcaos[aleatorio];
    }
}
