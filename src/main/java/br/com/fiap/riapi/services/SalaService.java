package br.com.fiap.riapi.services;

import br.com.fiap.riapi.domains.Conta;
import br.com.fiap.riapi.domains.Materia;
import br.com.fiap.riapi.repository.SalaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
public class SalaService {

    @Autowired
    SalaRepository salaRepository;

    @Autowired
    ContaService contaService;

    @Autowired
    MateriaService materiaService;

    Map<String, Object> responseMap = new HashMap<>();

    public ResponseEntity<Object> create(Integer cdConta, Integer cdMateria) {
        Optional<Conta> conta = contaService.findById(cdConta);
        if (conta.isEmpty()) {
            responseMap.put("status", HttpStatus.NOT_FOUND);
            responseMap.put("message", "Conta Not Found");
        }

        Optional<Materia> materia = materiaService.findById(cdMateria);
        if (materia.isEmpty()) {
            responseMap.put("status", HttpStatus.NOT_FOUND);
            responseMap.put("message", "Materia Not Found");
        }



        return null;

    }
}
