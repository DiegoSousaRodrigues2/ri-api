package br.com.fiap.riapi.controller;

import br.com.fiap.riapi.domains.Conta;
import br.com.fiap.riapi.services.ContaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("conta")
public class ContaController {

    @Autowired
    ContaService contaService;

    @GetMapping("getById")
    public Optional<Conta> getById(@RequestParam @Valid Integer cdConta){
        return contaService.findById(cdConta);
    }

    @GetMapping
    public Page<Conta> listAll(@PageableDefault(size = 10) Pageable pageable){
        return contaService.listAll(pageable);

    }

    @PostMapping("create")
    public ResponseEntity<Object> create(@RequestBody @Valid Conta conta, String token){
        ResponseEntity<Object> response = contaService.validateConta(conta, token);
        if(response != null){
            return response;
        }

        conta.setInstituicao(contaService.findInstitutionByToken(token));

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
