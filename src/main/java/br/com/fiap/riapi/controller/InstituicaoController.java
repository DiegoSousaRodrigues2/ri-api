package br.com.fiap.riapi.controller;

import br.com.fiap.riapi.domains.Instituicao;
import br.com.fiap.riapi.services.InstituicaoService;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.*;

@RestController
@RequestMapping("instituicao")
public class InstituicaoController {

    @Autowired
    private InstituicaoService instituicaoService;

    @GetMapping("teste")
    public int teste(@RequestParam Integer numero1, @RequestParam Integer numero2){
        return numero1 - numero2;
    }

    @GetMapping("")
    public Page<Instituicao> listAll(@PageableDefault(size = 10) Pageable pageable) {
        Page<Instituicao> instituicaos = instituicaoService.listAll(pageable);
        instituicaos.getSize();
        return instituicaos;
    }

    @GetMapping("findById")
    public Optional<Instituicao> findById(@RequestParam @Valid Integer id){
        return instituicaoService.findById(id);
    }

    @PostMapping("create")
    public ResponseEntity<Object> create(@RequestBody @Valid @NotNull Instituicao instituicao){

        ResponseEntity<Object> response = instituicaoService.validateIntituicao(instituicao, 0);
        if(response != null) {
            return response;
        }

        instituicaoService.save(instituicao);
        return ResponseEntity.status(HttpStatus.CREATED).body(instituicao);
    }

    @PutMapping("update")
    public ResponseEntity<Object> update(@RequestBody @Valid Instituicao instituicao, @RequestParam Integer id){
        ResponseEntity<Object> response = instituicaoService.validateIntituicaoUpdate(instituicao, id);
        if(response != null) {
            return response;
        }
        instituicao.setCdInstituicao(id);
        return ResponseEntity.status(HttpStatus.CREATED).body(instituicao);
    }

    @DeleteMapping("delete")
    public ResponseEntity<Object> delete(@RequestParam @Valid Integer id){
        return instituicaoService.deleteById(id);
    }

}

















