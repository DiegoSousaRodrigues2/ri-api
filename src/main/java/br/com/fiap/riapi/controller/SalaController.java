package br.com.fiap.riapi.controller;

import br.com.fiap.riapi.domains.Sala;
import br.com.fiap.riapi.services.SalaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.*;
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
    public Optional<Sala> findById(@RequestParam Integer cdSala){
        return salaService.findById(cdSala);
    }

    @PostMapping("create")
    public ResponseEntity<Object> create(@RequestParam Integer cdConta, Integer cdMateria){
        return salaService.create(cdConta, cdMateria);
    }

    @GetMapping("getByTurma")
    public ResponseEntity<Object> getByTurma(@RequestParam Integer turmaId, @RequestParam @Nullable Integer contaId){
        if(contaId != null){
            return salaService.getByTurmaIdAndContaId(turmaId, contaId);
        }
        return salaService.getByTurmaId(turmaId);

    }

}
