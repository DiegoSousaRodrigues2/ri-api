package br.com.fiap.riapi;

import br.com.fiap.riapi.command.AlunoCommand;
import br.com.fiap.riapi.controller.AlunoController;
import br.com.fiap.riapi.domains.Aluno;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/aluno/")
public class UrlMappings {

    @Autowired
    private AlunoController alunoController;

    Map<String, Object> response = new HashMap<>();

    /*
    *
    * API DIRECIONADA PARA CONSUMO DA BASE DE ALUNOS
    *
    */

    @GetMapping("getAll")
    public List<Aluno> getAllAluno(){
        return alunoController.getAllAluno();
    }

    @GetMapping("getById")
    public ResponseEntity<Aluno> getById(@RequestParam @Valid Integer cdAluno){
        return ResponseEntity.of(alunoController.findById(cdAluno));
    }

    @PostMapping("create")
    public ResponseEntity<Object> createAluno(@RequestBody @Valid Aluno aluno){

        String message = alunoController.save(aluno);

        //TODO fazer retorno para status não OK
        if(message.equals("ok")){
            return ResponseEntity.status(HttpStatus.CREATED).body(aluno);
        }
        return null;
    }

    @PutMapping("update")
    public ResponseEntity<Object> updateAluno(@RequestBody @Valid AlunoCommand alunoCommand , @RequestParam Integer id){

        String message = alunoController.update(alunoCommand, id);

        switch (message) {
            case "ok":
                return ResponseEntity.status(HttpStatus.CREATED).body(alunoCommand);

            case "has no identifier":
                response.put("Message", "Informe o Id");
                response.put("Status", HttpStatus.BAD_REQUEST);
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);

            case "identifier does not exist":
                response.put("Message", "Id não encontrado");
                response.put("Status", HttpStatus.BAD_REQUEST);
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        }
        return null;
    }

    /*
     *
     * API DIRECIONADA PARA LEITURA DO AUDIO QUE O ALUNO PASSAR
     *
     */

}
