package br.com.fiap.riapi.controller;

import br.com.fiap.riapi.domains.Feedback;
import br.com.fiap.riapi.services.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("feedback")
public class FeedbackController {

    @Autowired
    FeedbackService feedbackService;

    @PostMapping("create")
    public ResponseEntity<Object> create(@RequestBody Feedback feedback){
        feedback.setDsFileName("teste");
        feedback.setFileId("teste");
        return feedbackService.create(feedback);
    }

    @GetMapping("list")
    public ResponseEntity<Object> list(){
        List<Feedback> feedback = feedbackService.list();
        return ResponseEntity.status(HttpStatus.OK).body(feedback);
    }

    @GetMapping("getBySalaId")
    public ResponseEntity<Object> getBySalaId(@RequestParam Integer salaId){
        return ResponseEntity.status(HttpStatus.OK).body(feedbackService.findBySalaId(salaId));
    }

}

