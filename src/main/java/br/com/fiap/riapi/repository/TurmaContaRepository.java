package br.com.fiap.riapi.repository;

import br.com.fiap.riapi.domains.TurmaConta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TurmaContaRepository extends JpaRepository<TurmaConta, Integer> {
}
