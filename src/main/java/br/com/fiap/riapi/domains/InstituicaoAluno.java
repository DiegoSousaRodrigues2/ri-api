package br.com.fiap.riapi.domains;

import javax.persistence.*;

@Entity
@Table(name = "T_RATE_INSTITUICAO_ALUNO")
@SequenceGenerator(name = "instituicaoAluno", sequenceName = "SQ_TB_INSTITUICAO_ALUNO", allocationSize = 1)
public class InstituicaoAluno {

    //Construtor padrão
    public InstituicaoAluno() {
    }

    //Construtor sem id
    public InstituicaoAluno(Instituicao instituicao, Aluno aluno) {
        this.instituicao = instituicao;
        this.aluno = aluno;
    }

    //Construtor completo
    public InstituicaoAluno(Integer cdInstituicaoAluno, Instituicao instituicao, Aluno aluno) {
        this.cdInstituicaoAluno = cdInstituicaoAluno;
        this.instituicao = instituicao;
        this.aluno = aluno;
    }

    @Id
    @Column(name = "cd_instituicao_aluno", nullable = false, precision = 3)
    @GeneratedValue(generator = "instituicaoAluno", strategy = GenerationType.SEQUENCE)
    private Integer cdInstituicaoAluno;

    @ManyToOne
    @JoinColumn(name = "cd_instituicao", nullable = false)
    private Instituicao instituicao;

    @ManyToOne
    @JoinColumn(name = "cd_aluno", nullable = false)
    private Aluno aluno;

    public Integer getCdInstituicaoAluno() {
        return cdInstituicaoAluno;
    }

    public void setCdInstituicaoAluno(Integer cdInstituicaoAluno) {
        this.cdInstituicaoAluno = cdInstituicaoAluno;
    }

    public Instituicao getInstituicao() {
        return instituicao;
    }

    public void setInstituicao(Instituicao instituicao) {
        this.instituicao = instituicao;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }
}
