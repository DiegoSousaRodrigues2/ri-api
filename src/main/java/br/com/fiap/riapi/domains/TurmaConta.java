package br.com.fiap.riapi.domains;

import javax.persistence.*;

@Entity
@Table(name = "T_RATE_TURMA_CONTA")
@SequenceGenerator(name = "turmaConta", sequenceName = "SQ_TB_TURMA_CONTA", allocationSize = 1)
public class TurmaConta {

    public TurmaConta() {
    }

    public TurmaConta(Conta cdConta, Turma turma) {
        this.cdConta = cdConta;
        this.turma = turma;
    }

    public TurmaConta(Integer cdTurmaConta, Conta cdConta, Turma turma) {
        this.cdTurmaConta = cdTurmaConta;
        this.cdConta = cdConta;
        this.turma = turma;
    }

    @Id
    @GeneratedValue(generator = "turmaConta", strategy = GenerationType.SEQUENCE)
    @Column(name = "CD_TURMA_CONTA")
    private Integer cdTurmaConta;

    @ManyToOne
    @JoinColumn(name = "cd_conta", nullable = false)
    private Conta cdConta;

    @ManyToOne
    @JoinColumn(name = "cd_turma", nullable = false)
    private Turma turma;

    public Integer getCdTurmaConta() {
        return cdTurmaConta;
    }

    public TurmaConta setCdTurmaConta(Integer cdTurmaConta) {
        this.cdTurmaConta = cdTurmaConta;
        return this;
    }

    public Conta getCdConta() {
        return cdConta;
    }

    public TurmaConta setCdConta(Conta cdConta) {
        this.cdConta = cdConta;
        return this;
    }

    public Turma getTurma() {
        return turma;
    }

    public TurmaConta setTurma(Turma turma) {
        this.turma = turma;
        return this;
    }
}
