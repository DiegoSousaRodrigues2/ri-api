package br.com.fiap.riapi.domains;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "T_RATE_INSTITUICAO")
@SequenceGenerator(name = "instituicao", sequenceName = "SQ_TB_INSTITUICAO", allocationSize = 1)
public class Instituicao implements Serializable {

    //Construtor padrão
    public Instituicao() {
    }

    //Construtor sem id
    public Instituicao(String nmInstituicao, String nrCnpj, String ds_plano, String dsToken) {
        this.nmInstituicao = nmInstituicao;
        this.nrCnpj = nrCnpj;
        this.dsPlano = ds_plano;
        this.dsToken = dsToken;
    }

    //Construtor completo
    public Instituicao(Integer cdInstituicao, String nmInstituicao, String nrCnpj, String ds_plano, String dsToken) {
        this.cdInstituicao = cdInstituicao;
        this.nmInstituicao = nmInstituicao;
        this.nrCnpj = nrCnpj;
        this.dsPlano = ds_plano;
        this.dsToken = dsToken;
    }

    @Id
    @Column(name = "cd_instituicao", nullable = false, precision = 3)
    @GeneratedValue(generator = "instituicao", strategy = GenerationType.SEQUENCE)
    private Integer cdInstituicao;

    @Column(name = "nm_instituicao", nullable = false, length = 150, unique = true)
    private String nmInstituicao;

    @Column(name = "nr_cnpj", nullable = false, length = 18, unique = true)
    private String nrCnpj;

    @Column(name = "ds_plano", nullable = true, length = 50)
    private String dsPlano;

    @Column(name = "ds_token", nullable = false, length = 6, unique = true)
    private String dsToken;

    @JsonIgnore
    @OneToMany(mappedBy = "instituicao", cascade = CascadeType.ALL)
    private List<Conta> contaList = new ArrayList<Conta>();

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

    public String getDsPlano() {
        return dsPlano;
    }

    public void setDsPlano(String ds_plano) {
        this.dsPlano = ds_plano;
    }

    public String getDsToken() {
        return dsToken;
    }

    public void setDsToken(String dsToken) {
        this.dsToken = dsToken;
    }

    public List<Conta> getContaList() {
        return contaList;
    }

    public void setContaList(List<Conta> contaList) {
        this.contaList = contaList;
    }
}
