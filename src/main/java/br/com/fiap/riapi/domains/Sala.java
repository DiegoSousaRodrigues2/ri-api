package br.com.fiap.riapi.domains;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "T_RATE_SALA")
@SequenceGenerator(name = "sala", sequenceName = "SQ_TB_SALA", allocationSize = 1)
public class Sala {

    public Sala() {
    }

    public Sala(Turma turma, Conta conta, Materia materia) {
        this.turma = turma;
        this.conta = conta;
        this.materia = materia;
    }

    @Id
    @Column(name = "cd_sala", nullable = false, precision = 3)
    @GeneratedValue(generator = "sala", strategy = GenerationType.SEQUENCE)
    private Integer cdSala;

    @ManyToOne
    @JoinColumn(name = "cd_turma", nullable = false)
    Turma turma;

    @ManyToOne
    @JoinColumn(name = "cd_conta", nullable = false)
    private Conta conta;

    @ManyToOne
    @JoinColumn(name = "cd_materia", nullable = false)
    private Materia materia;

    @JsonIgnore
    @OneToMany(mappedBy = "sala", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Feedback> feedbackList;

    public Integer getCdSala() {
        return cdSala;
    }

    public Sala setCdSala(Integer cdSala) {
        this.cdSala = cdSala;
        return this;
    }

    public Conta getConta() {
        return conta;
    }

    public Sala setConta(Conta conta) {
        this.conta = conta;
        return this;
    }

    public Materia getMateria() {
        return materia;
    }

    public Sala setMateria(Materia materia) {
        this.materia = materia;
        return this;
    }

    public Turma getTurma() {
        return turma;
    }

    public Sala setTurma(Turma turma) {
        this.turma = turma;
        return this;
    }

    public List<Feedback> getFeedbackList() {
        return feedbackList;
    }

    public Sala setFeedbackList(List<Feedback> feedbackList) {
        this.feedbackList = feedbackList;
        return this;
    }
}
