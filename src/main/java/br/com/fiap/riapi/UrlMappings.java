package br.com.fiap.riapi;

import br.com.fiap.riapi.controller.AlunoController;
import br.com.fiap.riapi.domains.Aluno;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.json.GsonJsonParser;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class UrlMappings {
    Map<String, String> response = new HashMap<>();

    @Autowired
    private AlunoController alunoController;

    @GetMapping("/aluno/getAll")
    public List<Aluno> getAllAluno(){
        return alunoController.getAllAluno();
    }

    @PostMapping("/aluno/create")
    public ResponseEntity createAluno(@RequestBody @Valid Aluno aluno){

        String message = alunoController.save(aluno);

        if(message.equals("ok")){
            return ResponseEntity.status(HttpStatus.CREATED).body(aluno);
        }else{
            response.put("Message", "Idade menor que 18 anos");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        }
    }

    @PutMapping("/aluno/update")
    public ResponseEntity updateAluno(@RequestBody @Valid Aluno aluno){

        if(aluno.getCdAluno() == null){
            response.put("Message", "Informe o Id");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        }

        String message = alunoController.save(aluno);

        if(message.equals("ok")){
            return ResponseEntity.status(HttpStatus.CREATED).body(aluno);
        }else{
            response.put("Message", "Idade menor que 18 anos");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        }
    }

}
