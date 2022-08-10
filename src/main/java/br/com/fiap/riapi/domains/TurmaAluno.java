package br.com.fiap.riapi.domains;

import javax.persistence.*;

@Entity
@Table(name = "T_RATE_TURMA_ALUNO")
@SequenceGenerator(name = "turmaAluno", sequenceName = "SQ_TB_TURMA_ALUNO", allocationSize = 1)
public class TurmaAluno {

    //Construtor padrão
    public TurmaAluno() {
    }

    //Construtor sem id
    public TurmaAluno(Aluno aluno, Turma turma) {
        this.aluno = aluno;
        this.turma = turma;
    }

    //Construtor completo
    public TurmaAluno(Integer cdTurmaAluno, Aluno aluno, Turma turma) {
        this.cdTurmaAluno = cdTurmaAluno;
        this.aluno = aluno;
        this.turma = turma;
    }

    @Id
    @Column(name = "cd_turma_aluno", nullable = false, precision = 3)
    @GeneratedValue(generator = "turmaAluno", strategy = GenerationType.SEQUENCE)
    private Integer cdTurmaAluno;

    @ManyToOne
    @JoinColumn(name = "cd_aluno", nullable = false)
    private Aluno aluno;

    @ManyToOne
    @JoinColumn(name = "cd_turma", nullable = false)
    private Turma turma;

    public Integer getCdTurmaAluno() {
        return cdTurmaAluno;
    }

    public void setCdTurmaAluno(Integer cdTurmaAluno) {
        this.cdTurmaAluno = cdTurmaAluno;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public Turma getTurma() {
        return turma;
    }

    public void setTurma(Turma turma) {
        this.turma = turma;
    }
}
