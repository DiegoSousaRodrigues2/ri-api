package br.com.fiap.riapi.controller;

import br.com.fiap.riapi.domains.Conta;
import br.com.fiap.riapi.services.ContaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Map;
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
    public ResponseEntity<Object> create(@RequestBody @Valid Conta conta, @RequestParam String token){
        ResponseEntity<Object> response = contaService.validateConta(conta, token, 0);
        if(response != null){
            return response;
        }

        conta.setInstituicao(contaService.findInstitutionByToken(token));
        contaService.save(conta);
        return ResponseEntity.status(HttpStatus.CREATED).body(conta);
    }

    @PutMapping("update")
    public ResponseEntity<Object> update(@RequestBody @Valid Conta conta, @RequestParam Integer cdConta){

        ResponseEntity<Object> response = contaService.validateUpdateConta(conta, cdConta);

        conta.setCdConta(cdConta);
        return ResponseEntity.status(HttpStatus.OK).body(conta);
    }

    @GetMapping("oauth")
    public Map<String, Object> update(@RequestParam @Valid String email, @RequestParam String senha){
        return contaService.oauth(email, senha);
    }
}
