package br.com.fiap.riapi.services;

import br.com.fiap.riapi.domains.Conta;
import br.com.fiap.riapi.domains.Instituicao;
import br.com.fiap.riapi.repository.ContaRepository;
import br.com.fiap.riapi.repository.InstituicaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
public class ContaService {

    @Autowired
    ContaRepository contaRepository;

    Map<String, Object> responseMap = new HashMap<>();

    public Optional<Conta> findById(Integer cdConta) {
        Optional<Conta> teste = contaRepository.findById(cdConta);
        return teste;

    }

    public Page<Conta> listAll(Pageable pageable) {
        return contaRepository.findAll(pageable);
    }

    public ResponseEntity<Object> validateConta(Conta conta, String token) {

        if (contaRepository.findByDsEmail(conta.getDsEmail()).size() > 0) {
            responseMap.put("status", HttpStatus.BAD_REQUEST);
            responseMap.put("message", "email document");
        }

        if (contaRepository.findByDsDocumento(conta.getDsDocumento()).size() > 0) {
            responseMap.put("status", HttpStatus.BAD_REQUEST);
            responseMap.put("message", "duplicated document");
        }

//        if (instituicaoRepository.findByDsToken(token).size() == 0) {
//            responseMap.put("status", HttpStatus.NOT_FOUND);
//            responseMap.put("message", "token not found");
//        }

        //TODO Validate Document

        return null;
    }


//    public Instituicao findInstitutionByToken(String token) {
//        return instituicaoRepository.findByDsToken(token).get(0);
//    }
}
