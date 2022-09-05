package br.com.fiap.riapi.controller;

import br.com.fiap.riapi.domains.Curso;
import br.com.fiap.riapi.services.CursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("curso")
public class CursoController {

    @Autowired
    CursoService cursoService;

    @GetMapping("getById")
    public Optional<Curso> findById(@RequestParam @Valid Integer cdCurso){
        return cursoService.getById(cdCurso);
    }

    @GetMapping
    public Page<Curso> listAll(@PageableDefault Pageable pageable){
        return cursoService.listAll(pageable);
    }

    @PostMapping("create")
    public ResponseEntity<Object> create(@RequestBody @Valid Curso curso){
        ResponseEntity<Object> response= cursoService.validateCurso(curso);
        if(response != null){
            return response;
        }

        curso.setTurmaList(new ArrayList<>());
        curso.setCursoMateriaList(new ArrayList<>());

        cursoService.save(curso);
        return ResponseEntity.status(HttpStatus.CREATED).body(curso);
    }

    @PutMapping("update")
    public ResponseEntity<Object> update(@RequestBody @Valid Curso curso, @RequestParam Integer cdCurso){
        ResponseEntity<Object> response = cursoService.update(curso, cdCurso);
        if(response != null){
            return response;
        }
        curso.setCdCurso(cdCurso);
        return ResponseEntity.status(HttpStatus.OK).body(curso);
    }

    @DeleteMapping("delete")
    public ResponseEntity<Curso> delete(@RequestParam Integer cdCurso){
        Optional<Curso> optionalCurso = cursoService.getById(cdCurso);

        if (optionalCurso.isEmpty()) return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

        cursoService.deletedById(cdCurso);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
