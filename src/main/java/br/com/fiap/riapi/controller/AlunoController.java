package br.com.fiap.riapi.controller;

import br.com.fiap.riapi.domains.Aluno;
import br.com.fiap.riapi.services.AlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Optional;

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



        return null;
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
}
