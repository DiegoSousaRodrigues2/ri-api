package br.com.fiap.riapi.repository;

import br.com.fiap.riapi.domains.Sala;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface SalaRepository extends JpaRepository<Sala, Integer> {
}
