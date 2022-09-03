package br.com.fiap.riapi.domains;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "T_RATE_CONTA")
@SequenceGenerator(name = "conta", sequenceName = "SQ_TB_CONTA", allocationSize = 1)
public class Conta implements Serializable {

    public Conta() {
    }

    public Conta(String nmConta, String dsEmail, String dsSenha, String dsDocumento, Date dtNascimento, Boolean stConta, String dsTipoConta, Instituicao instituicao) {
        this.nmConta = nmConta;
        this.dsEmail = dsEmail;
        this.dsSenha = dsSenha;
        this.dsDocumento = dsDocumento;
        this.dtNascimento = dtNascimento;
        this.stConta = stConta;
        this.dsTipoConta = dsTipoConta;
        this.instituicao = instituicao;
    }

    public Conta(Integer cdConta, String nmConta, String dsEmail, String dsSenha, String dsDocumento, Date dtNascimento, Boolean stConta, String dsTipoConta, Instituicao instituicao) {
        this.cdConta = cdConta;
        this.nmConta = nmConta;
        this.dsEmail = dsEmail;
        this.dsSenha = dsSenha;
        this.dsDocumento = dsDocumento;
        this.dtNascimento = dtNascimento;
        this.stConta = stConta;
        this.dsTipoConta = dsTipoConta;
        this.instituicao = instituicao;
    }

    @Id
    @Column(name = "cd_conta")
    @GeneratedValue(generator = "conta", strategy = GenerationType.SEQUENCE)
    private Integer cdConta;

    @Column(name = "nm_conta", nullable = false, length = 150)
    private String nmConta;

    @Column(name = "ds_email", nullable = false, length = 150, unique = true)
    private String dsEmail;

    @Column(name = "ds_senha", nullable = false, length = 150)
    private String dsSenha;

    @Column(name = "ds_documento", nullable = false, length = 150, unique = true)
    private String dsDocumento;

    @Column(name = "dt_nascimento", nullable = false)
    private Date dtNascimento;

    @Column(name = "st_conta", nullable = false)
    private Boolean stConta;

    @Column(name = "ds_tipo_conta", nullable = false, length = 1)
    private String dsTipoConta;

    @JsonIgnore
    @OneToMany(mappedBy = "conta", cascade = CascadeType.ALL)
    private List<TurmaConta> turmaContaList = new ArrayList<TurmaConta>();

    @JsonIgnore
    @OneToMany(mappedBy = "conta", cascade = CascadeType.ALL)
    private List<AvaliacaoDiaria> avaliacaoDiariaList = new ArrayList<AvaliacaoDiaria>();

    @ManyToOne
    @JoinColumn(name = "cd_instituicao", nullable = false)
    private Instituicao instituicao;

    public List<TurmaConta> getTurmaContaList() {
        return turmaContaList;
    }

    public Conta setTurmaContaList(List<TurmaConta> turmaContaList) {
        this.turmaContaList = turmaContaList;
        return this;
    }

    public List<AvaliacaoDiaria> getAvaliacaoDiariaList() {
        return avaliacaoDiariaList;
    }

    public Conta setAvaliacaoDiariaList(List<AvaliacaoDiaria> avaliacaoDiariaList) {
        this.avaliacaoDiariaList = avaliacaoDiariaList;
        return this;
    }

    public Integer getCdConta() {
        return cdConta;
    }

    public void setCdConta(Integer cdConta) {
        this.cdConta = cdConta;
    }

    public String getNmConta() {
        return nmConta;
    }

    public void setNmConta(String nmConta) {
        this.nmConta = nmConta;
    }

    public String getDsEmail() {
        return dsEmail;
    }

    public void setDsEmail(String dsEmail) {
        this.dsEmail = dsEmail;
    }

    public String getDsSenha() {
        return dsSenha;
    }

    public void setDsSenha(String dsSenha) {
        this.dsSenha = dsSenha;
    }

    public String getDsDocumento() {
        return dsDocumento;
    }

    public void setDsDocumento(String dsDocumento) {
        this.dsDocumento = dsDocumento;
    }

    public Date getDtNascimento() {
        return dtNascimento;
    }

    public void setDtNascimento(Date dtNascimento) {
        this.dtNascimento = dtNascimento;
    }

    public Boolean getStConta() {
        return stConta;
    }

    public void setStConta(Boolean stConta) {
        this.stConta = stConta;
    }

    public String getDsTipoConta() {
        return dsTipoConta;
    }

    public void setDsTipoConta(String dsTipoConta) {
        this.dsTipoConta = dsTipoConta;
    }

    public Instituicao getInstituicao() {
        return instituicao;
    }

    public void setInstituicao(Instituicao instituicao) {
        this.instituicao = instituicao;
    }
}
