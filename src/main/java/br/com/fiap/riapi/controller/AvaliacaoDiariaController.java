package br.com.fiap.riapi.controller;

import br.com.fiap.riapi.domains.AvaliacaoDiaria;
import br.com.fiap.riapi.services.AvaliacaoDiariaService;
import org.apache.tomcat.jni.File;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

@Controller
@RequestMapping("avaliacaoDiaria")
public class AvaliacaoDiariaController {

    @Autowired
    AvaliacaoDiariaService avaliacaoDiariaService;

    @PostMapping("upload")
    public String upload(@RequestParam @Valid MultipartFile file, @RequestParam String emailAluno, String materia){
        avaliacaoDiariaService.saveFile(file, emailAluno, materia);
        return "Foi";
    }



}
