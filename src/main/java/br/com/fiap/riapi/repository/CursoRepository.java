package br.com.fiap.riapi.repository;

import br.com.fiap.riapi.domains.Curso;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CursoRepository  extends JpaRepository<Curso, Integer> {
}
