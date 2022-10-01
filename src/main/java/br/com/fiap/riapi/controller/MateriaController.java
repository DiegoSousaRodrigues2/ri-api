package br.com.fiap.riapi.controller;

import br.com.fiap.riapi.domains.Curso;
import br.com.fiap.riapi.domains.Materia;
import br.com.fiap.riapi.services.MateriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("materia")
public class MateriaController {

    @Autowired
    MateriaService materiaService;

    @GetMapping("getById")
    public ResponseEntity<Materia> getById(@RequestParam Integer cdMateria){
        return ResponseEntity.of(materiaService.findById(cdMateria));
    }

    @GetMapping
    public Page<Materia> listAll(@PageableDefault Pageable pageable){
        return materiaService.listAll(pageable);
    }

    @PostMapping("create")
    public ResponseEntity<Object> create(@RequestBody @Valid Materia materia){
        materiaService.save(materia);
        return ResponseEntity.status(HttpStatus.OK).body(materia);
    }

    @PutMapping("update")
    public ResponseEntity<Object> update(@RequestBody @Valid Materia materia, @RequestParam Integer cdMateria){
        ResponseEntity<Object> response = materiaService.update(materia, cdMateria);
        if(response != null){
            return response;
        }
        materia.setCdMateria(cdMateria);
        return ResponseEntity.status(HttpStatus.OK).body(materia);
    }


    @DeleteMapping("delete")
    public ResponseEntity<Object> delete(@RequestParam Integer cdMateria){
        materiaService.delete(cdMateria);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @PostMapping("associarMateriaCurso")
    public ResponseEntity<Object> associarMateriaCurso(@RequestParam Integer cdMateria, @RequestParam Integer cdCurso){
        return materiaService.associarMateriaCurso(cdMateria, cdCurso);
    }

}
