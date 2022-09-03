package br.com.fiap.riapi.domains;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "T_RATE_MATERIA")
@SequenceGenerator(name = "materia", sequenceName = "SQ_TB_MATERIA", allocationSize = 1)
public class Materia {

    //Construtor padrão
    public Materia() {
    }

    //Construtor sem id
    public Materia(String nmMateria, String dsMateria) {
        this.nmMateria = nmMateria;
        this.dsMateria = dsMateria;
    }

    //Construtor completo
    public Materia(Integer cdMateria, String nmMateria, String dsMateria) {
        this.cdMateria = cdMateria;
        this.nmMateria = nmMateria;
        this.dsMateria = dsMateria;
    }

    @Id
    @Column(name = "cd_materia", nullable = false, precision = 3)
    @GeneratedValue(generator = "materia", strategy = GenerationType.SEQUENCE)
    private Integer cdMateria;

    @Column(name = "nm_materia", nullable = false, length = 50)
    private String nmMateria;

    @Column(name = "ds_materia", nullable = false, length = 200)
    private String dsMateria;

    @JsonIgnore
    @OneToMany(mappedBy = "materia")
    private List<CursoMateria> cursoMateriaList;

    @JsonIgnore
    @OneToMany(mappedBy = "materia")
    private List<AvaliacaoDiaria> avaliacaoDiariaList;

    public Integer getCdMateria() {
        return cdMateria;
    }

    public void setCdMateria(Integer cdMateria) {
        this.cdMateria = cdMateria;
    }

    public String getNmMateria() {
        return nmMateria;
    }

    public void setNmMateria(String nmMateria) {
        this.nmMateria = nmMateria;
    }

    public String getDsMateria() {
        return dsMateria;
    }

    public void setDsMateria(String dsMateria) {
        this.dsMateria = dsMateria;
    }

    public List<CursoMateria> getCursoMateriaList() {
        return cursoMateriaList;
    }

    public void setCursoMateriaList(List<CursoMateria> cursoMateriaList) {
        this.cursoMateriaList = cursoMateriaList;
    }
}
