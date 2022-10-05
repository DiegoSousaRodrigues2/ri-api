package br.com.fiap.riapi.controller;

import br.com.fiap.riapi.domains.Feedback;
import br.com.fiap.riapi.domains.Sala;
import br.com.fiap.riapi.services.SalaService;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("sala")
public class SalaController {

    @Autowired
    SalaService salaService;

    @GetMapping("")
    public Object listAll(@PageableDefault(size = 10) Pageable pageable){
        Page<Sala> salas =  salaService.listAll(pageable);
        if(salas.getSize() == 0){
            return null;
        }
        return salas;
    }

    @GetMapping("findById")
    public ResponseEntity<Object> findById(@RequestParam Integer cdSala){
        Sala sala = salaService.getFeedbackList(cdSala);
        List<Feedback> feedbackList = sala.getFeedbackList();
        sala.setFeedbackList(feedbackList);
        return ResponseEntity.status(HttpStatus.OK).body(sala);
    }

    @PostMapping("create")
    public ResponseEntity<Object> create(@RequestParam Integer cdConta, Integer cdMateria, Integer turmaId){
        return salaService.create(cdConta, cdMateria, turmaId);
    }

    @GetMapping("getByTurma")
    public ResponseEntity<Object> getByTurma(@RequestParam Integer turmaId, @RequestParam @Nullable Integer contaId){
        if(contaId != null){
            return salaService.getByTurmaIdAndContaId(turmaId, contaId);
        }
        return salaService.getByTurmaId(turmaId);

    }



}
