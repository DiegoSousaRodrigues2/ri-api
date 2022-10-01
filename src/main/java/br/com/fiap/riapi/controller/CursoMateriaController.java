package br.com.fiap.riapi.controller;

import br.com.fiap.riapi.domains.CursoMateria;
import br.com.fiap.riapi.services.CursoMateriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("curso/materia")
public class CursoMateriaController {

    @Autowired
    CursoMateriaService cursoMateriaService;

    @GetMapping
    public Page<CursoMateria> listAll(@PageableDefault Pageable pageable){
        return cursoMateriaService.listAll(pageable);
    }

    @GetMapping("findById")
    public ResponseEntity<CursoMateria> findById(@RequestParam Integer cdCursoMateria){
        return ResponseEntity.of(cursoMateriaService.findById(cdCursoMateria));
    }

    @PostMapping("create")
    public ResponseEntity<CursoMateria> create(@RequestBody CursoMateria cursoMateria){
        cursoMateriaService.save(cursoMateria);
        return ResponseEntity.status(HttpStatus.OK).body(cursoMateria);
    }

    @DeleteMapping("delete")
    public ResponseEntity<CursoMateria> delete(@RequestParam Integer cdCursoMateria){
        cursoMateriaService.delete(cdCursoMateria);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
