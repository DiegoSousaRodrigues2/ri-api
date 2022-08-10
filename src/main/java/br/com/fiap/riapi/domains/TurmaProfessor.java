package br.com.fiap.riapi.domains;

import javax.persistence.*;

@Entity
@Table(name = "T_RATE_TURMA_PROFESSOR")
@SequenceGenerator(name = "turmaProfessor", sequenceName = "SQ_TB_TURMA_PROFESSOR", allocationSize = 1)
public class TurmaProfessor {

    //Construtor padrão
    public TurmaProfessor() {
    }

    //Construtor sem id
    public TurmaProfessor(Professor professor, Turma turma) {
        this.professor = professor;
        this.turma = turma;
    }

    //Construtor completo
    public TurmaProfessor(Integer cdTurmaProfessor, Professor professor, Turma turma) {
        this.cdTurmaProfessor = cdTurmaProfessor;
        this.professor = professor;
        this.turma = turma;
    }

    @Id
    @Column(name = "cd_turma_professor", nullable = false, precision = 3)
    @GeneratedValue(generator = "turmaProfessor", strategy = GenerationType.SEQUENCE)
    private Integer cdTurmaProfessor;

    @ManyToOne
    @JoinColumn(name = "cd_professor", nullable = false)
    private Professor professor;

    @ManyToOne
    @JoinColumn(name = "cd_turma", nullable = false)
    private Turma turma;

    public Integer getCdTurmaProfessor() {
        return cdTurmaProfessor;
    }

    public void setCdTurmaProfessor(Integer cdTurmaProfessor) {
        this.cdTurmaProfessor = cdTurmaProfessor;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    public Turma getTurma() {
        return turma;
    }

    public void setTurma(Turma turma) {
        this.turma = turma;
    }
}
