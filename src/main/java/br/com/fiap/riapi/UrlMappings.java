package br.com.fiap.riapi;

import br.com.fiap.riapi.controller.AlunoController;
import br.com.fiap.riapi.domains.Aluno;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UrlMappings {

    @Autowired
    private AlunoController alunoController;

    @GetMapping("/aluno/getAll")
    public List<Aluno> getAllAluno(){
        return alunoController.getAllAluno();
    }

}
