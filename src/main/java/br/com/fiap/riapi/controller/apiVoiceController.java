package br.com.fiap.riapi.controller;

import br.com.fiap.riapi.services.apiVoiceService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("apiVoice")
public class apiVoiceController {

    apiVoiceService apiVoiceService = new apiVoiceService();

    @GetMapping("/health/drive")
    public Object healthDrive() throws IOException {
        return apiVoiceService.healthDrive();
    }

    @GetMapping("health/zamzar")
    public Object healthZamzar() throws IOException {
        return apiVoiceService.healthZamzar();
    }

}
