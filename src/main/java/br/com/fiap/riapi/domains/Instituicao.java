package br.com.fiap.riapi.domains;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "T_RATE_INSTITUICAO")
@SequenceGenerator(name = "instituicao", sequenceName = "SQ_TB_INSTITUICAO", allocationSize = 1)
public class Instituicao {

    //Construtor padrão
    public Instituicao() {
    }

    //Construtor sem id
    public Instituicao(String nmInstituicao, String nrCnpj, String ds_plano) {
        this.nmInstituicao = nmInstituicao;
        this.nrCnpj = nrCnpj;
        this.ds_plano = ds_plano;
    }

    //Construtor completo
    public Instituicao(Integer cdInstituicao, String nmInstituicao, String nrCnpj, String ds_plano) {
        this.cdInstituicao = cdInstituicao;
        this.nmInstituicao = nmInstituicao;
        this.nrCnpj = nrCnpj;
        this.ds_plano = ds_plano;
    }

    @Id
    @Column(name = "cd_instituicao", nullable = false, precision = 3)
    @GeneratedValue(generator = "instituicao", strategy = GenerationType.SEQUENCE)
    private Integer cdInstituicao;

    @Column(name = "nm_instituicao", nullable = false, length = 50)
    private String nmInstituicao;

    @Column(name = "nr_cnpj", nullable = false, length = 18)
    private String nrCnpj;

    @Column(name = "ds_plano", nullable = true, length = 50)
    private String ds_plano;

    //Mapeamento Bidirecional InstituicaoProfessor
    @OneToMany(mappedBy = "instituicao")
    private List<InstituicaoProfessor> instituicaoProfessorList;

    //Mapeamento Bidirecional InstituicaoAluno
    @OneToMany(mappedBy = "instituicao")
    private List<InstituicaoAluno> insttuicaoAlunoList;

    public Integer getCdInstituicao() {
        return cdInstituicao;
    }

    public void setCdInstituicao(Integer cdInstituicao) {
        this.cdInstituicao = cdInstituicao;
    }

    public String getNmInstituicao() {
        return nmInstituicao;
    }

    public void setNmInstituicao(String nmInstituicao) {
        this.nmInstituicao = nmInstituicao;
    }

    public String getNrCnpj() {
        return nrCnpj;
    }

    public void setNrCnpj(String nrCnpj) {
        this.nrCnpj = nrCnpj;
    }

    public String getDs_plano() {
        return ds_plano;
    }

    public void setDs_plano(String ds_plano) {
        this.ds_plano = ds_plano;
    }
}
