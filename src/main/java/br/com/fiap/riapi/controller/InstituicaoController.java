package br.com.fiap.riapi.controller;

import br.com.fiap.riapi.domains.Instituicao;
import br.com.fiap.riapi.services.InstituicaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("instituicao")
public class InstituicaoController {

    @Autowired
    private InstituicaoService instituicaoService;

    @GetMapping("")
    public Page<Instituicao> getAll(@PageableDefault(size = 10) Pageable pageable) {
        return instituicaoService.listAll(pageable);
    }

    @GetMapping("getById")
    public Optional<Instituicao> findById(@RequestParam @Valid Integer id){
        return instituicaoService.findById(id);
    }

    @PostMapping("create")
    public ResponseEntity<Instituicao> create(@RequestBody @Valid Instituicao instituicao){
        instituicao.setContaList(new ArrayList<>());
        String response = instituicaoService.save(instituicao);

        if(!response.equals("ok")){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(instituicao);
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(instituicao);
    }
}
