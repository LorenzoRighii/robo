package br.com.joaocarloslima.robo.controller;

import br.com.joaocarloslima.robo.model.Direcao;
import br.com.joaocarloslima.robo.model.Posicao;
import br.com.joaocarloslima.robo.model.Sala;

public interface Rota {
    String getNome();
    Direcao proximaDirecao(Sala sala, Posicao atual);
}
