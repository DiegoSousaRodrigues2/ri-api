package br.com.fiap.riapi.services;

import br.com.fiap.riapi.domains.*;
import br.com.fiap.riapi.models.ListSalaContaTurma;
import br.com.fiap.riapi.repository.SalaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class SalaService {

    @Autowired
    SalaRepository salaRepository;
    @Autowired
    ContaService contaService;
    @Autowired
    MateriaService materiaService;
    @Autowired
    TurmaContaService turmaContaService;
    @Autowired
    TurmaService turmaService;
    @Autowired
    FeedbackService feedbackService;

    Map<String, Object> responseMap = new HashMap<>();

    public ResponseEntity<Object> create(Integer cdConta, Integer cdMateria, Integer turmaId) {
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

        Optional<Turma> turma = turmaService.findById(turmaId);
        if (turma.isEmpty()) {
            responseMap.put("status", HttpStatus.NOT_FOUND);
            responseMap.put("message", "Materia Not Found");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(responseMap);
        }

        Sala sala = new Sala(turma.get(), conta.get(), materia.get());

        save(sala);

        return ResponseEntity.status(HttpStatus.CREATED).body(sala);
    }

    public void save(Sala sala) {
        salaRepository.save(sala);
    }

    public Page<Sala> listAll(Pageable pageable) {
        return salaRepository.findAll(pageable);
    }

    public Optional<Sala> findById(Integer cdSala) {
        return salaRepository.findById(cdSala);
    }

    public Sala getFeedbackList(Integer cdSala) {
        return salaRepository.getFeedbackList(cdSala).get(0);
    }

    public ResponseEntity<Object> getByTurmaId(Integer turmaId) {
        Optional<Turma> turma = turmaService.findById(turmaId);
        if (turma.isEmpty()) {
            responseMap.put("status", HttpStatus.NOT_FOUND);
            responseMap.put("message", "turma Not Found");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(responseMap);
        }

        List<Object> salaListByTurmaId = turmaContaService.getSalaListByTurmaId(turmaId);

        return ResponseEntity.status(HttpStatus.OK).body(salaListByTurmaId);
    }

    public ResponseEntity<Object> getByTurmaIdAndContaId(Integer turmaId, Integer contaId) {
        Optional<Turma> turma = turmaService.findById(turmaId);
        if (turma.isEmpty()) {
            responseMap.put("status", HttpStatus.NOT_FOUND);
            responseMap.put("message", "turma Not Found");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(responseMap);
        }

        Optional<Conta> conta = contaService.findById(contaId);
        if (conta.isEmpty()) {
            responseMap.put("status", HttpStatus.NOT_FOUND);
            responseMap.put("message", "conta Not Found");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(responseMap);
        }

        return ResponseEntity.status(HttpStatus.OK).body(turmaContaService.getSalaListByTurmaIdAndAlunId(turmaId, contaId));
    }
}
