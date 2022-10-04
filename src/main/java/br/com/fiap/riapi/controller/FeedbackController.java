package br.com.fiap.riapi.controller;

import br.com.fiap.riapi.services.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;

@Controller
@RequestMapping("feedback")
public class FeedbackController {

    @Autowired
    FeedbackService feedbackService;

    @PostMapping("upload")
    public String upload(@RequestParam @Valid MultipartFile file, @RequestParam String emailAluno, String materia){
        feedbackService.saveFile(file, emailAluno, materia);
        return "Foi";
    }



}
