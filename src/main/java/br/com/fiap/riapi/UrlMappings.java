package br.com.fiap.riapi;

import br.com.fiap.riapi.controller.AlunoController;
import br.com.fiap.riapi.domains.Aluno;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import javax.validation.Valid;
import java.util.List;

@RestController
public class UrlMappings {

    @Autowired
    private AlunoController alunoController;

    @GetMapping("/aluno/getAll")
    public List<Aluno> getAllAluno(){
        return alunoController.getAllAluno();
    }

    @PostMapping("/aluno/create")
    public ResponseEntity<Aluno> create(@RequestBody @Valid Aluno aluno){

        alunoController.save(aluno);

        return ResponseEntity.status(HttpStatus.CREATED).body(aluno);
    }

}
