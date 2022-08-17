package br.com.fiap.riapi.controller;

import br.com.fiap.riapi.command.AlunoCommand;
import br.com.fiap.riapi.domains.Aluno;
import br.com.fiap.riapi.services.AlunoService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.*;

@Service
public class AlunoController {

    @Autowired
    AlunoService alunoService;

    public List<Aluno> getAllAluno(){
        return alunoService.findAll();
    }

    public String save(Aluno aluno) {
        if(Birthday(aluno.getDtNascimento()) < 18){
            return "Not of age";
        }
        alunoService.save(aluno);
        return "ok";
    }

    public String update(AlunoCommand alunoCommand, Integer id){

        if(id == null){
            return "has no identifier";
        }

        if(findById(id).isEmpty()){
            return "identifier does not exist";
        }

        Aluno aluno = new Aluno();
        BeanUtils.copyProperties(alunoCommand, aluno);
        aluno.setCdAluno(id);

        save(aluno);
        return "ok";
    }

    private int Birthday(Date birthday) {
        Calendar dataNascimento = Calendar.getInstance();
        dataNascimento.setTime(birthday);
        Calendar hoje = Calendar.getInstance();
        int idade = hoje.get(Calendar.YEAR) - dataNascimento.get(Calendar.YEAR);
        if (hoje.get(Calendar.MONTH) < dataNascimento.get(Calendar.MONTH)) {
            idade--;
        }
        else
        {
            if (hoje.get(Calendar.MONTH) == dataNascimento.get(Calendar.MONTH) && hoje.get(Calendar.DAY_OF_MONTH) < dataNascimento.get(Calendar.DAY_OF_MONTH)) {
                idade--;
            }
        }
        return idade;
    }

    public Optional<Aluno> findById(Integer cdAluno) {
        return alunoService.findById(cdAluno);
    }

    private void copiar(File origem, OutputStream destino) {
        int bite = 0; byte[]
                tamanhoMaximo = new byte[1024 * 8]; // 8KB
        try {
            // enquanto bytes forem sendo lidos
            while((bite = origem.read(tamanhoMaximo)) >= 0) {
                // pegue o byte lido e escreva no destino
                destino.write(tamanhoMaximo, 0, bite);
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block e.printStackTrace();
        }
    }

    public void upload(String pasta, String nomeDoArquivo, File arquivoCarregado) throws FileNotFoundException {
        String caminhoArquivo = pasta + "/" + nomeDoArquivo;
        File novoArquivo = new File(caminhoArquivo);
        FileOutputStream saida = new FileOutputStream(novoArquivo);
        copiar(arquivoCarregado, saida);
    }
}
