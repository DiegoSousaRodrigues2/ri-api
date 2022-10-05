package br.com.fiap.riapi.services;

import br.com.fiap.riapi.domains.Feedback;
import br.com.fiap.riapi.repository.FeedbackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FeedbackService {

    @Autowired
    FeedbackRepository feedbackRepository;
    @Autowired
    SalaService salaService;

    public ResponseEntity<Object> create(Feedback feedback) {
        save(feedback);
        return ResponseEntity.status(HttpStatus.OK).body(feedback);
    }

    public void save(Feedback feedback){
        feedbackRepository.save(feedback);
    }

    public List<Feedback> list() {
        return feedbackRepository.findAll();
    }

    public List<Feedback> findBySalaId(Integer salaId){
        List<Feedback> bySalaId = feedbackRepository.findBySalaId(salaService.findById(salaId).get());
        for (Feedback a: bySalaId) {
            a.setConta(null);
            a.setCdSala(null);
        }
        return bySalaId;
    }
}
