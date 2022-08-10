package br.com.fiap.riapi.services;

import br.com.fiap.riapi.domains.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlunoService extends JpaRepository<Aluno, Integer> {

}
