package br.com.fiap.riapi.controller;

import br.com.fiap.riapi.domains.Aluno;
import br.com.fiap.riapi.services.AlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class AlunoController {

    @Autowired
    AlunoService alunoService;

    public List<Aluno> getAllAluno(){
        return alunoService.findAll();
    }

    public String save(Aluno aluno) {
        if(Birthday(aluno.getDtNascimento()) < 18){
            return "Not of age";
        }
        alunoService.save(aluno);
        return "ok";
    }

    public String update(Aluno aluno){

        if(aluno.getCdAluno() == null){
            return "has no identifier";
        }

        if(findById(aluno.getCdAluno()).isEmpty() == true){
            return "identifier does not exist";
        }

        save(aluno);

        return "ok";
    }

    private int Birthday(Date birthday) {
        Calendar dataNascimento = Calendar.getInstance();
        dataNascimento.setTime(birthday);
        Calendar hoje = Calendar.getInstance();
        int idade = hoje.get(Calendar.YEAR) - dataNascimento.get(Calendar.YEAR);
        if (hoje.get(Calendar.MONTH) < dataNascimento.get(Calendar.MONTH)) {
            idade--;
        }
        else
        {
            if (hoje.get(Calendar.MONTH) == dataNascimento.get(Calendar.MONTH) && hoje.get(Calendar.DAY_OF_MONTH) < dataNascimento.get(Calendar.DAY_OF_MONTH)) {
                idade--;
            }
        }
        return idade;
    }

    public Optional<Aluno> findById(Integer cdAluno) {
        return alunoService.findById(cdAluno);
    }
}
