package br.com.fiap.riapi.domains;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "T_RATE_AVALIACAO_DIARIA")
@SequenceGenerator(name = "avaliacaoDiaria", sequenceName = "SQ_TB_AVALIACAO_DIARIA", allocationSize = 1)
public class AvaliacaoDiaria {

    public AvaliacaoDiaria() {
    }

    public AvaliacaoDiaria(Conta conta, Materia materia, String dsAvaliacao, Integer nrEstrela, Date dtAvaliacao) {
        this.conta = conta;
        this.materia = materia;
        this.dsAvaliacao = dsAvaliacao;
        this.nrEstrela = nrEstrela;
        this.dtAvaliacao = dtAvaliacao;
    }

    public AvaliacaoDiaria(Integer cdAvaliacaoDiaria, Conta conta, Materia materia, String dsAvaliacao, Integer nrEstrela, Date dtAvaliacao) {
        this.cdAvaliacaoDiaria = cdAvaliacaoDiaria;
        this.conta = conta;
        this.materia = materia;
        this.dsAvaliacao = dsAvaliacao;
        this.nrEstrela = nrEstrela;
        this.dtAvaliacao = dtAvaliacao;
    }

    @Id
    @Column(name = "cd_avaliacao_diaria", nullable = false, precision = 3)
    @GeneratedValue(generator = "avaliacaoDiaria", strategy = GenerationType.SEQUENCE)
    private Integer cdAvaliacaoDiaria;

    @ManyToOne
    @JoinColumn(name = "cd_conta", nullable = false)
    private Conta conta;

    @ManyToOne
    @JoinColumn(name = "cd_materia", nullable = false)
    private Materia materia;

    @Column(name = "ds_avaliacao", nullable = false, length = 255)
    private String dsAvaliacao;

    @Column(name = "nr_estrela", nullable = false, precision = 3)
    private Integer nrEstrela;

    @Column(name = "dt_avaliacao", nullable = false)
    private Date dtAvaliacao;

    public Integer getCdAvaliacaoDiaria() {
        return cdAvaliacaoDiaria;
    }

    public AvaliacaoDiaria setCdAvaliacaoDiaria(Integer cdAvaliacaoDiaria) {
        this.cdAvaliacaoDiaria = cdAvaliacaoDiaria;
        return this;
    }

    public Conta getConta() {
        return conta;
    }

    public AvaliacaoDiaria setConta(Conta conta) {
        this.conta = conta;
        return this;
    }

    public Materia getMateria() {
        return materia;
    }

    public AvaliacaoDiaria setMateria(Materia materia) {
        this.materia = materia;
        return this;
    }

    public String getDsAvaliacao() {
        return dsAvaliacao;
    }

    public AvaliacaoDiaria setDsAvaliacao(String dsAvaliacao) {
        this.dsAvaliacao = dsAvaliacao;
        return this;
    }

    public Integer getNrEstrela() {
        return nrEstrela;
    }

    public AvaliacaoDiaria setNrEstrela(Integer nrEstrela) {
        this.nrEstrela = nrEstrela;
        return this;
    }

    public Date getDtAvaliacao() {
        return dtAvaliacao;
    }

    public AvaliacaoDiaria setDtAvaliacao(Date dtAvaliacao) {
        this.dtAvaliacao = dtAvaliacao;
        return this;
    }
}
