package br.com.fiap.riapi.repository;

import br.com.fiap.riapi.domains.Sala;
import br.com.fiap.riapi.domains.TurmaConta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TurmaContaRepository extends JpaRepository<TurmaConta, Integer> {
    @Query("select tc from TurmaConta tc where tc.conta.cdConta = ?1")
    List<TurmaConta> listTurmaContaById(Integer contaId);

    @Query("select s.conta.salaList from TurmaConta s where s.turma.cdTurma = ?1")
    List<Object> getSalaListByTurmaId(Integer turmaId);

    @Query("select s.conta.salaList from TurmaConta s where s.turma.cdTurma = ?1 and s.conta.cdConta = ?2")
    List<Sala> getSalaListByContaId(Integer turmaId, Integer contaId);

}
