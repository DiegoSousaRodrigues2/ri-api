package br.com.fiap.riapi.controller;

import br.com.fiap.riapi.domains.TurmaConta;
import br.com.fiap.riapi.services.SalaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("sala")
public class SalaController {

    @Autowired
    SalaService salaService;

    @PostMapping("create")
    public ResponseEntity<Object> create(@RequestParam Integer cdConta, Integer cdMateria){
        return salaService.create(cdConta, cdMateria);
    }

}
