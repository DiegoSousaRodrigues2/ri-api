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

    @GetMapping("")
    public Page<Instituicao> getAll(@PageableDefault(size = 10) Pageable pageable) {
        return instituicaoService.listAll(pageable);
    }

    @GetMapping("getById")
    public Optional<Instituicao> findById(@RequestParam @Valid Integer id){
        return instituicaoService.findById(id);
    }

    @PostMapping("create")
    public ResponseEntity<Object> create(@RequestBody @Valid @NotNull Instituicao instituicao){
        instituicao.setContaList(new ArrayList<>());

        ResponseEntity<Object> response = validateIntituicaoCreate(instituicao);
        if(response != null){
            return response;
        }

        return ResponseEntity.status(HttpStatus.CREATED).body(instituicao);
    }

    public ResponseEntity<Object> validateIntituicaoCreate(Instituicao instituicao){
        String response = instituicaoService.save(instituicao);

        Map<String, Object> responseMap = new HashMap<>();

        if(!response.equals("ok")) {
            responseMap.put("status", HttpStatus.BAD_REQUEST);
            responseMap.put("message", response);
            if (response.equals("duplicated name")) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseMap);
            } else if (response.equals("duplicated document")) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseMap);
            } else if (instituicao.getDsToken() != null && (!instituicao.getDsPlano().toLowerCase().equals("basico") || !instituicao.getDsPlano().toLowerCase().equals("pro"))) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseMap);
            } else if (response.equals("duplicated token")) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseMap);
            }

            //TODO criar validador de CNPJ
        }
        return null;
    }
}
