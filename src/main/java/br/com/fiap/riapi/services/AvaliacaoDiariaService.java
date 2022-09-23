package br.com.fiap.riapi.services;

import br.com.fiap.riapi.repository.AvaliacaoDiariaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Calendar;
import java.util.Date;

@Service
public class AvaliacaoDiariaService {

    @Autowired
    AvaliacaoDiariaRepository avaliacaoDiariaRepository;

    public void saveFile(MultipartFile file, String emailAluno, String materia) {
        String fileName = encriptName(emailAluno, materia);
        save(file, fileName);
    }

    public String encriptName(String emailAluno, String materia) {
        Date data = new Date();
        Calendar cal = Calendar.getInstance();
        cal.setTime(data);
        int day = cal.get(Calendar.DAY_OF_MONTH);
        int month = cal.get(Calendar.MONTH);
        int year = cal.get(Calendar.YEAR);

        return emailAluno + "." + materia + "." + month + "." + day + "." + year;
    }

    public String verifyType(String fileName) {

        if (!fileName.endsWith(".wav")) {

        }
        return "ok";
    }

    public void save(MultipartFile arquivo, String fileName) {
        Path path = Paths.get("./src/main/java/br/com/fiap/riapi/files");
        Path realPath = path.resolve(fileName + ".png");

        try {
            Files.createDirectories(path);
            arquivo.transferTo(realPath);
        } catch (IOException e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
