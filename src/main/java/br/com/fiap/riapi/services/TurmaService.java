package br.com.fiap.riapi.services;

import br.com.fiap.riapi.domains.Conta;
import br.com.fiap.riapi.domains.Curso;
import br.com.fiap.riapi.domains.Turma;
import br.com.fiap.riapi.domains.TurmaConta;
import br.com.fiap.riapi.repository.TurmaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class TurmaService {

    @Autowired
    TurmaRepository turmaRepository;

    @Autowired
    ContaService contaService;

    @Autowired
    TurmaContaService turmaContaService;

    @Autowired
    CursoService cursoService;

    Map<String, Object> responseMap = new HashMap<>();

    public Page<Turma> listAll(Pageable pageable) {
        return turmaRepository.findAll(pageable);
    }

    public void save(Turma turma) {
        turmaRepository.save(turma);
    }

    public Optional<Turma> findById(Integer cdTurma) {
        return turmaRepository.findById(cdTurma);
    }

    public ResponseEntity<Object> associarTurmaAluno(Integer turmaId, Integer contaId) {
        Optional<Turma> turma = findById(turmaId);
        if (turma.isEmpty()) {
            responseMap.put("status", HttpStatus.NOT_FOUND);
            responseMap.put("message", "Turma Not Found");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(responseMap);
        }
        Optional<Conta> conta = contaService.findById(contaId);
        if (conta.isEmpty()) {
            responseMap.put("status", HttpStatus.NOT_FOUND);
            responseMap.put("message", "Conta Not Found");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(responseMap);
        }
        TurmaConta turmaConta = new TurmaConta();

        turmaConta.setTurma(turma.get());
        turmaConta.setCdConta(conta.get());

        turmaContaService.save(turmaConta);
        return ResponseEntity.status(HttpStatus.OK).body(turmaConta);
    }

    public ResponseEntity<Object> listTurmasByConta(Integer contaId) {
        List<TurmaConta> turmaContaList = turmaContaService.listTurmasByConta(contaId);

        if(turmaContaList.size() > 0){
            return ResponseEntity.status(HttpStatus.OK).body(turmaContaList);
        }

        responseMap.put("status", HttpStatus.NOT_FOUND);
        responseMap.put("message", "Not Found");
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(responseMap);
    }


    public ResponseEntity<Object> createTurma(String nmTurma, Integer cdCurso) {
        Turma turma = new Turma();
        Optional<Curso> curso = cursoService.findById(cdCurso);

        if(curso.isEmpty()){
            responseMap.put("status", HttpStatus.NOT_FOUND);
            responseMap.put("message", "Curso Not Found");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(responseMap);
        }

        turma.setNmTurma(nmTurma);
        turma.setCurso(curso.get());


        save(turma);
        return ResponseEntity.status(HttpStatus.OK).body(turma);
    }
}
