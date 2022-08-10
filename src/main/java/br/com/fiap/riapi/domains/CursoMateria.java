package br.com.fiap.riapi.domains;

import javax.persistence.*;

@Entity
@Table(name = "T_RATE_CURSO_MATERIA")
@SequenceGenerator(name = "cursoMateria", sequenceName = "SQ_TB_MATERIA", allocationSize = 1)
public class CursoMateria {

    public CursoMateria() {
    }

    public CursoMateria(Materia materia, Curso curso) {
        this.materia = materia;
        this.curso = curso;
    }

    public CursoMateria(Integer cdCursoMateria, Materia materia, Curso curso) {
        this.cdCursoMateria = cdCursoMateria;
        this.materia = materia;
        this.curso = curso;
    }

    @Id
    @Column(name = "cd_curso_materia", nullable = false, precision = 3)
    @GeneratedValue(generator = "cursoMateria", strategy = GenerationType.SEQUENCE)
    private Integer cdCursoMateria;

    @ManyToOne
    @JoinColumn(name = "cd_materia", nullable = false)
    private Materia materia;

    @ManyToOne
    @JoinColumn(name = "cd_Curso", nullable = false)
    private Curso curso;

    public Integer getCdCursoMateria() {
        return cdCursoMateria;
    }

    public void setCdCursoMateria(Integer cdCursoMateria) {
        this.cdCursoMateria = cdCursoMateria;
    }

    public Materia getMateria() {
        return materia;
    }

    public void setMateria(Materia materia) {
        this.materia = materia;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }
}
