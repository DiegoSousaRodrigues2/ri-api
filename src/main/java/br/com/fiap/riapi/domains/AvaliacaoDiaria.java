package br.com.fiap.riapi.domains;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "T_RATE_AVALIACAO_DIARIA")
@SequenceGenerator(name = "avaliacaoDiaria", sequenceName = "SQ_TB_AVALIACAO_DIARIA", allocationSize = 1)
public class AvaliacaoDiaria {

    public AvaliacaoDiaria() {
    }

    public AvaliacaoDiaria(Aluno aluno, Materia materia, String dsAvaliacao, Integer nrEstrela, Date dtAvaliacao) {
        this.aluno = aluno;
        this.materia = materia;
        this.dsAvaliacao = dsAvaliacao;
        this.nrEstrela = nrEstrela;
        this.dtAvaliacao = dtAvaliacao;
    }

    public AvaliacaoDiaria(Integer cdAvaliacaoDiaria, Aluno aluno, Materia materia, String dsAvaliacao, Integer nrEstrela, Date dtAvaliacao) {
        this.cdAvaliacaoDiaria = cdAvaliacaoDiaria;
        this.aluno = aluno;
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
    @JoinColumn(name = "cd_aluno", nullable = false)
    private Aluno aluno;

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

    public void setCdAvaliacaoDiaria(Integer cdAvaliacaoDiaria) {
        this.cdAvaliacaoDiaria = cdAvaliacaoDiaria;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public Materia getMateria() {
        return materia;
    }

    public void setMateria(Materia materia) {
        this.materia = materia;
    }
}
