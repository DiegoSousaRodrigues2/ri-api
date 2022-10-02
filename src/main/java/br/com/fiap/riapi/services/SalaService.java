package br.com.fiap.riapi.services;

import br.com.fiap.riapi.domains.Conta;
import br.com.fiap.riapi.domains.Instituicao;
import br.com.fiap.riapi.domains.Materia;
import br.com.fiap.riapi.domains.Sala;
import br.com.fiap.riapi.repository.SalaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(responseMap);
        }

        Optional<Materia> materia = materiaService.findById(cdMateria);
        if (materia.isEmpty()) {
            responseMap.put("status", HttpStatus.NOT_FOUND);
            responseMap.put("message", "Materia Not Found");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(responseMap);
        }

        Sala sala = new Sala(conta.get(), materia.get());

        save(sala);

        return ResponseEntity.status(HttpStatus.CREATED).body(sala);
    }

    public void save(Sala sala){
        salaRepository.save(sala);
    }

    public Page<Sala> listAll(Pageable pageable) {
        return salaRepository.findAll(pageable);
    }

    public Optional<Sala> findById(Integer cdSala) {
        return salaRepository.findById(cdSala);
    }
}
