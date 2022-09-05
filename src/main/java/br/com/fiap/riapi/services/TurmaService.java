package br.com.fiap.riapi.services;

import br.com.fiap.riapi.domains.Turma;
import br.com.fiap.riapi.repository.TurmaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TurmaService {

    @Autowired
    TurmaRepository turmaRepository;

    public Page<Turma> listAll(Pageable pageable) {
        return turmaRepository.findAll(pageable);
    }

    public void save(Turma turma) {
        turmaRepository.save(turma);
    }

    public Optional<Turma> getById(Integer cdTurma) {
        return turmaRepository.findById(cdTurma);
    }
}
