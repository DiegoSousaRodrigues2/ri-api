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
import java.util.Optional;

@RestController
public class UrlMappings {

    @Autowired
    private AlunoController alunoController;

    Map<String, Object> response = new HashMap<>();

    @GetMapping("/aluno/getAll")
    public List<Aluno> getAllAluno(){
        return alunoController.getAllAluno();
    }

    @GetMapping("/aluno/getById")
    public Optional<Aluno> getById(@RequestParam @Valid Integer cdAluno){
        return alunoController.findById(cdAluno);
    }

    @PostMapping("/aluno/create")
    public ResponseEntity createAluno(@RequestBody @Valid Aluno aluno){

        String message = alunoController.save(aluno);

        if(message.equals("ok")){
            return ResponseEntity.status(HttpStatus.CREATED).body(aluno);
        }
        return null;
    }

    @PutMapping("/aluno/update")
    public ResponseEntity updateAluno(@RequestBody @Valid Aluno aluno){

        String message = alunoController.update(aluno);

        if(message.equals("ok")){
            return ResponseEntity.status(HttpStatus.CREATED).body(aluno);
        }else if (message.equals("has no identifier")){
            response.put("Message", "Informe o Id");
            response.put("Status", HttpStatus.BAD_REQUEST);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        }else if (message.equals("identifier does not exist")){
            response.put("Message", "Id não encontrado");
            response.put("Status", HttpStatus.BAD_REQUEST);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        }
        return null;
    }

}
