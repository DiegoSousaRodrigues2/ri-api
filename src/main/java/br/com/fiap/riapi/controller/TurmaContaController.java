package br.com.fiap.riapi.controller;

import br.com.fiap.riapi.domains.TurmaConta;
import br.com.fiap.riapi.services.TurmaContaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("turma/conta")
public class TurmaContaController {

    @Autowired
    TurmaContaService turmaContaService;

    @GetMapping
    public Page<TurmaConta> listAll(@PageableDefault Pageable pageable){
        return turmaContaService.findAll(pageable);
    }

    @GetMapping("getById")
    public ResponseEntity<TurmaConta> getById(@RequestParam Integer cdTurmaConta){
        return ResponseEntity.of(turmaContaService.findById(cdTurmaConta));
    }

    @PostMapping("create")
    public ResponseEntity<TurmaConta> create(@RequestBody TurmaConta turmaConta){
        turmaContaService.save(turmaConta);
        return ResponseEntity.status(HttpStatus.OK).body(turmaConta);
    }

}
