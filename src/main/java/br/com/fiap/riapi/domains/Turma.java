package br.com.fiap.riapi.domains;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "T_RATE_TURMA")
@SequenceGenerator(name = "turma", sequenceName = "SQ_TB_TURMA", allocationSize = 1)
public class Turma {

    //Construtor padrão
    public Turma() {
    }

    //Construtor sem id
    public Turma(String nmTurma) {
        this.nmTurma = nmTurma;
    }

    //Construtor completo
    public Turma(Integer cdTurma, String nmTurma) {
        this.cdTurma = cdTurma;
        this.nmTurma = nmTurma;
    }

    @Id
    @Column(name = "cd_turma", nullable = false, precision = 3)
    @GeneratedValue(generator = "turma", strategy = GenerationType.SEQUENCE)
    private Integer cdTurma;

    @Column(name = "nm_turma", nullable = false,  length = 50)
    private String nmTurma;

    @ManyToOne
    @JoinColumn(name = "cd_curso",nullable = false)
    public Curso curso;

    public Integer getCdTurma() {
        return cdTurma;
    }

    public void setCdTurma(Integer cdTurma) {
        this.cdTurma = cdTurma;
    }

    public String getNmTurma() {
        return nmTurma;
    }

    public void setNmTurma(String nmTurma) {
        this.nmTurma = nmTurma;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

}
