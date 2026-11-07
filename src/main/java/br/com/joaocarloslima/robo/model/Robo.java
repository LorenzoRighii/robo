package br.com.joaocarloslima.robo.model;

import br.com.joaocarloslima.robo.controller.Rota;

import java.util.Random;

public class Robo  {
    private Rota rota;
    private Posicao posicao;
    private Direcao direcao = Direcao.DIREITA;
    private int passos;
    private int batidas;
    private Random random = new Random();

    public Robo(Posicao inicio, Rota rota) {
        this.posicao = inicio;
        this.rota = rota;
    }

    public void andar(Sala sala) {
        direcao = rota.proximaDirecao(sala, posicao);
        Posicao destino = posicao.mover(direcao);
        if (sala.livre(destino)) {
            posicao = destino;
            sala.limpar(posicao);
        } else {
            batidas++;
        }
        passos++;
    }

    // cada modo de limpeza novo vira mais um if aqui dentro...
    private Direcao proximaDirecao(Sala sala) {
        if (rota.equals("Aleatória")) {
            return sortearDirecao();
        }

        if (rota.equals("Ricochete")) {
            // segue reto e, quando bate, sorteia outra direção
            if (!sala.livre(posicao.mover(direcao))) {
                direcao = sortearDirecao();
            }
            return direcao;
        }

        return direcao;
    }

    private Direcao sortearDirecao() {
        Direcao[] direcoes = Direcao.values();
        return direcoes[random.nextInt(direcoes.length)];
    }

    public void setRota(Rota rota) {
        this.rota = rota;
    }

    public String getNomeDaRota() {
        return rota.getNome();
    }

    public Posicao getPosicao() {
        return posicao;
    }

    public Direcao getDirecao() {
        return direcao;
    }

    public int getPassos() {
        return passos;
    }

    public int getBatidas() {
        return batidas;
    }
}
