package br.com.fiap.riapi.command;

import java.sql.Date;

public class AlunoCommand {
    String nmAluno;
    Date dtNascimento;
    Boolean stAluno;

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
}
