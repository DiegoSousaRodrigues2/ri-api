package br.com.fiap.riapi.repository;

import br.com.fiap.riapi.domains.TurmaConta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TurmaContaRepository extends JpaRepository<TurmaConta, Integer> {
    @Query("select tc from TurmaConta tc where tc.conta.cdConta = ?1")
    List<TurmaConta> listTurmaContaById(Integer contaId);
}
