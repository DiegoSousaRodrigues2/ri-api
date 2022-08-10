package br.com.fiap.riapi.domains;

import javax.persistence.*;

@Entity
@Table(name = "T_RATE_INSTITUICAO_PROFESSOR")
@SequenceGenerator(name = "instituicaoProfessor", sequenceName = "SQ_TB_INSTITUICAO_PROFESSOR", allocationSize = 1)
public class InstituicaoProfessor {

    //Construtor padrão
    public InstituicaoProfessor() {
    }

    //Construtor sem id
    public InstituicaoProfessor(Professor professor, Instituicao instituicao) {
        this.professor = professor;
        this.instituicao = instituicao;
    }

    //Construtor completo
    public InstituicaoProfessor(Integer cdInstituicaoProfessor, Professor professor, Instituicao instituicao) {
        this.cdInstituicaoProfessor = cdInstituicaoProfessor;
        this.professor = professor;
        this.instituicao = instituicao;
    }

    @Id
    @Column(name = "cd_instituicao_professor", nullable = false, precision = 3)
    @GeneratedValue(generator = "instituicaoProfessor", strategy = GenerationType.SEQUENCE)
    private Integer cdInstituicaoProfessor;

    @ManyToOne
    @JoinColumn(name = "cd_professor", nullable = false)
    private Professor professor;

    @ManyToOne
    @JoinColumn(name = "cd_instituicao", nullable = false)
    private Instituicao instituicao;

    public Integer getCdInstituicaoProfessor() {
        return cdInstituicaoProfessor;
    }

    public void setCdInstituicaoProfessor(Integer cdInstituicaoProfessor) {
        this.cdInstituicaoProfessor = cdInstituicaoProfessor;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    public Instituicao getInstituicao() {
        return instituicao;
    }

    public void setInstituicao(Instituicao instituicao) {
        this.instituicao = instituicao;
    }
}
