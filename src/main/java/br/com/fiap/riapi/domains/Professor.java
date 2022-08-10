package br.com.fiap.riapi.domains;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

@Entity
@Table(name = "T_RATE_PROFESSOR")
@SequenceGenerator(name = "professor", sequenceName = "SQ_TB_PROFESSOR", allocationSize = 1)
public class Professor {

    //Construtor padrão
    public Professor() {
    }

    //Construtor sem id
    public Professor(String nmProfessor, Date dtNascimento, Boolean stProfessor) {
        this.nmProfessor = nmProfessor;
        this.dtNascimento = dtNascimento;
        this.stProfessor = stProfessor;
    }

    //Construtor completo
    public Professor(Integer cdProfessor, String nmProfessor, Date dtNascimento, Boolean stProfessor) {
        this.cdProfessor = cdProfessor;
        this.nmProfessor = nmProfessor;
        this.dtNascimento = dtNascimento;
        this.stProfessor = stProfessor;
    }

    @Id
    @Column(name = "cd_professor", nullable = false, precision = 3)
    @GeneratedValue(generator = "professor", strategy = GenerationType.SEQUENCE)
    private Integer cdProfessor;

    @Column(name = "nm_professor", nullable = false, length = 50)
    private String nmProfessor;

    @Column(name = "dt_nascimento", nullable = false)
    private Date dtNascimento;

    @Column(name = "st_professor", nullable = false, length = 1)
    private Boolean stProfessor;

    //Mapeamento Bidirecional InstituicaoProfessor
    @OneToMany(mappedBy = "professor", cascade = CascadeType.ALL)
    private List<InstituicaoProfessor> instituicaoProfessorList;

    @OneToMany(mappedBy = "professor", cascade = CascadeType.ALL)
    private List<TurmaProfessor> turmaProfessorList;

    public Integer getCdProfessor() {
        return cdProfessor;
    }

    public void setCdProfessor(Integer cdProfessor) {
        this.cdProfessor = cdProfessor;
    }

    public String getNmProfessor() {
        return nmProfessor;
    }

    public void setNmProfessor(String nmProfessor) {
        this.nmProfessor = nmProfessor;
    }

    public Date getDtNascimento() {
        return dtNascimento;
    }

    public void setDtNascimento(Date dtNascimento) {
        this.dtNascimento = dtNascimento;
    }

    public Boolean getStProfessor() {
        return stProfessor;
    }

    public void setStProfessor(Boolean stProfessor) {
        this.stProfessor = stProfessor;
    }

    public List<InstituicaoProfessor> getInstituicaoProfessorList() {
        return instituicaoProfessorList;
    }

    public void setInstituicaoProfessorList(List<InstituicaoProfessor> instituicaoProfessorList) {
        this.instituicaoProfessorList = instituicaoProfessorList;
    }

    public List<TurmaProfessor> getTurmaProfessorList() {
        return turmaProfessorList;
    }

    public void setTurmaProfessorList(List<TurmaProfessor> turmaProfessorList) {
        this.turmaProfessorList = turmaProfessorList;
    }
}
