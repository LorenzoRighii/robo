package br.com.joaocarloslima.robo.model;

import br.com.joaocarloslima.robo.controller.Aleatoria;
import br.com.joaocarloslima.robo.controller.Ricochete;
import br.com.joaocarloslima.robo.controller.Rota;
import br.com.joaocarloslima.robo.controller.ZigueZague;

import java.util.ArrayList;
import java.util.List;

public class Simulador {
    public static final int LIMITE_PASSOS = 300; // a bateria do robô
    private static final Posicao BASE = new Posicao(0, 0);

    private Sala sala = new Sala();
    private Robo robo = new Robo(BASE, new Aleatoria());

    // TODO: trocar a lista de nomes por uma lista de rotas
    private List<Rota> rotas () {
        return List.of(new Aleatoria(), new Ricochete(), new ZigueZague()); }

    public List<String> nomesDasRotas() {
        List<String> nomes = new ArrayList<>();
        for (Rota rota: rotas()){
            nomes.add(rota.getNome());

        }
        return nomes;
    }

    public void escolherRota(String nome) {
        robo.setRota(criaRota(nome));
    }

    private Rota criaRota(String nome) {
        for (Rota rota : rotas()){
            if (rota.getNome().equals(nome)) {
                return rota;
            }
        }
        throw new IllegalArgumentException("rota desconhecida " + nome);
    }

    public boolean passo() {
        if (robo.getPassos() >= LIMITE_PASSOS) {
            return false;
        }
        robo.andar(sala);
        return true;
    }

    public List<Resultado> ranking() {
        List<Resultado> resultados = new ArrayList<>();
        for (Rota rota : rotas()) {
            Sala salaDoTeste = new Sala();
            Robo roboDoTeste = new Robo(BASE, rota);
            for (int i = 0; i < LIMITE_PASSOS; i++) {
                roboDoTeste.andar(salaDoTeste);
            }
            resultados.add(new Resultado(rota.getNome(), salaDoTeste.getPercentualLimpo(), roboDoTeste.getBatidas()));
        }
        return resultados;
    }

    public void reiniciar() {
        String rotaAtual = robo.getNomeDaRota();
        sala = new Sala();
        robo = new Robo(BASE, criaRota(rotaAtual));    }

    public Sala getSala() {
        return sala;
    }

    public Robo getRobo() {
        return robo;
    }
}
