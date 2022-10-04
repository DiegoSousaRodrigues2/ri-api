package br.com.fiap.riapi.models;

import br.com.fiap.riapi.domains.Conta;
import br.com.fiap.riapi.domains.Sala;
import br.com.fiap.riapi.domains.Turma;
import java.util.List;

public class ListSalaContaTurma {

    public ListSalaContaTurma() {
    }

    public ListSalaContaTurma(List<Sala> salas, Conta conta) {
        this.salas = salas;
        this.conta = conta;
    }

    List<Sala> salas;
    Conta conta;
    Turma turma;

    public List<Sala> getSalas() {
        return salas;
    }

    public ListSalaContaTurma setSalas(List<Sala> salas) {
        this.salas = salas;
        return this;
    }

    public Conta getConta() {
        return conta;
    }

    public ListSalaContaTurma setConta(Conta conta) {
        this.conta = conta;
        return this;
    }

    public Turma getTurma() {
        return turma;
    }

    public ListSalaContaTurma setTurma(Turma turma) {
        this.turma = turma;
        return this;
    }
}
