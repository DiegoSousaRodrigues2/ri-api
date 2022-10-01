package br.com.fiap.riapi.controller;

import br.com.fiap.riapi.domains.Turma;
import br.com.fiap.riapi.services.TurmaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("turma")
public class TurmaController {

    @Autowired
    TurmaService turmaService;

    @GetMapping("/")
    public Page<Turma> listAll(@PageableDefault Pageable pageable){
        return turmaService.listAll(pageable);
    }

    @GetMapping("getById")
    public ResponseEntity<Turma> getById(@RequestParam Integer cdTurma){
        return ResponseEntity.of(turmaService.getById(cdTurma));
    }

    @PostMapping("create")
    public ResponseEntity<Object> create(@RequestParam String nmTurma, @RequestParam Integer cdCurso){
        return turmaService.createTurma(nmTurma, cdCurso);
    }

    @PostMapping("associate")
    public ResponseEntity<Object> associarTurmaAluno(@RequestParam Integer turmaId, @RequestParam Integer contaId){
        return turmaService.associarTurmaAluno(turmaId, contaId);
    }

    @GetMapping("listTurmasByConta")
    public ResponseEntity<Object> listTurmasByConta(@RequestParam Integer contaId){
        return turmaService.listTurmasByConta(contaId);
    }

}
