package br.com.fiap.riapi.repository;

import br.com.fiap.riapi.domains.Sala;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

public interface SalaRepository extends JpaRepository<Sala, Integer> {

    @Query("select s, s.feedbackList from Sala s where s.cdSala = ?1")
    List<Sala> getFeedbackList(Integer cdSala);

}
