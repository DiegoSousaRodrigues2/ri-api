package br.com.fiap.riapi.controller;

import br.com.fiap.riapi.GoogleDriveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.security.GeneralSecurityException;

@RestController
@RequestMapping("googleDrive")
public class GoogleDriveController {

    GoogleDriveService googleDriveService = new GoogleDriveService();

    @GetMapping("oauth")
    public String oauth() throws GeneralSecurityException, IOException {
        googleDriveService.oauth();
        return "ok";
    }

}
