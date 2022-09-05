package br.com.fiap.riapi.services;

import br.com.fiap.riapi.domains.TurmaConta;
import br.com.fiap.riapi.repository.TurmaContaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TurmaContaService {

    @Autowired
    TurmaContaRepository turmaContaRepository;

    public Page<TurmaConta> findAll(Pageable pageable) {
        return turmaContaRepository.findAll(pageable);
    }

    public Optional<TurmaConta> findById(Integer cdTurmaConta) {
        return turmaContaRepository.findById(cdTurmaConta);
    }

    public void save(TurmaConta turmaConta) {
        turmaContaRepository.save(turmaConta);
    }
}
