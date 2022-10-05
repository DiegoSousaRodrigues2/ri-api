package br.com.fiap.riapi.repository;

import br.com.fiap.riapi.domains.Feedback;
import br.com.fiap.riapi.domains.Sala;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface FeedbackRepository extends JpaRepository<Feedback, Integer> {

    @Query("select f from Feedback f where f.sala = ?1")
    List<Feedback> findBySalaId(Sala salaId);

    Optional<Feedback> findBySala(Sala sala);

}