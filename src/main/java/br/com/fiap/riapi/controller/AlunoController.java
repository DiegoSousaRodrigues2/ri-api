package br.com.fiap.riapi.controller;

import br.com.fiap.riapi.domains.Aluno;
import br.com.fiap.riapi.services.AlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlunoController {

    @Autowired
    AlunoService alunoService;

    public List<Aluno> getAllAluno(){
        return alunoService.findAll();


    }

}
