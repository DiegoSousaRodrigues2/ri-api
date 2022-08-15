package br.com.fiap.riapi.domains;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

@Entity
@Table(name = "T_RATE_ALUNO")
@SequenceGenerator(name = "aluno", sequenceName = "SQ_TB_ALUNO", allocationSize = 1)
public class Aluno {

    //Construtor padrão
    public Aluno() {
    }

    //Construtor sem id
    public Aluno(String nmAluno, Date dtNascimento, Boolean stAluno) {
        this.nmAluno = nmAluno;
        this.dtNascimento = dtNascimento;
        this.stAluno = stAluno;
    }

    //Construtor completo
    public Aluno(Integer cdAluno, String nmAluno, Date dtNascimento, Boolean stAluno) {
        this.cdAluno = cdAluno;
        this.nmAluno = nmAluno;
        this.dtNascimento = dtNascimento;
        this.stAluno = stAluno;
    }

    @Id
    @Column(name = "cd_aluno", nullable = false, precision = 3)
    @GeneratedValue(generator = "aluno", strategy = GenerationType.SEQUENCE)
    private Integer cdAluno;

    @Column(name = "nm_aluno", nullable = false, length = 50)
    private String nmAluno;

    @Column(name = "dt_nascimento", nullable = false)
    private Date dtNascimento;

    @Column(name = "st_aluno", nullable = false)
    private Boolean stAluno;

    //Mapeamento Bidirecional InstituicaoAluno
    @OneToMany(mappedBy = "aluno")
    private List<InstituicaoAluno> insttuicaoAlunoList;

    @OneToMany(mappedBy = "materia")
    private List<AvaliacaoDiaria> avaliacaoDiariaList;

    public Integer getCdAluno() {
        return cdAluno;
    }

    public void setCdAluno(Integer cdAluno) {
        this.cdAluno = cdAluno;
    }

    public String getNmAluno() {
        return nmAluno;
    }

    public void setNmAluno(String nmAluno) {
        this.nmAluno = nmAluno;
    }

    public Date getDtNascimento() {
        return dtNascimento;
    }

    public void setDtNascimento(Date dtNascimento) {
        this.dtNascimento = dtNascimento;
    }

    public Boolean getStAluno() {
        return stAluno;
    }

    public void setStAluno(Boolean stAluno) {
        this.stAluno = stAluno;
    }

    public List<InstituicaoAluno> getInsttuicaoAlunoList() {
        return insttuicaoAlunoList;
    }

    public void setInsttuicaoAlunoList(List<InstituicaoAluno> insttuicaoAlunoList) {
        this.insttuicaoAlunoList = insttuicaoAlunoList;
    }
}
