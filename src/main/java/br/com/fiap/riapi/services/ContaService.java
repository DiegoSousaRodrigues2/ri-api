package br.com.fiap.riapi.services;

import br.com.fiap.riapi.domains.Conta;
import br.com.fiap.riapi.domains.Instituicao;
import br.com.fiap.riapi.repository.ContaRepository;
import br.com.fiap.riapi.repository.InstituicaoRepository;
import org.springframework.beans.BeanUtils;
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

    @Autowired
    InstituicaoRepository instituicaoRepository;

    Map<String, Object> responseMap = new HashMap<>();

    public Optional<Conta> findById(Integer cdConta) {
        return contaRepository.findById(cdConta);

    }

    public Page<Conta> listAll(Pageable pageable) {
        return contaRepository.findAll(pageable);
    }

    public ResponseEntity<Object> validateConta(Conta conta, String token, Integer cdConta) {

        if (contaRepository.findByDsEmail(conta.getDsEmail(), cdConta).size() > 0) {
            responseMap.put("status", HttpStatus.BAD_REQUEST);
            responseMap.put("message", "duplicated email");
        } else if (contaRepository.findByDsDocumento(conta.getDsDocumento(), cdConta).size() > 0) {
            responseMap.put("status", HttpStatus.BAD_REQUEST);
            responseMap.put("message", "duplicated document");
        } else if (instituicaoRepository.findByDsToken(token, cdConta).size() == 0) {
            responseMap.put("status", HttpStatus.NOT_FOUND);
            responseMap.put("message", "token not found");
        } else {
            responseMap.clear();
        }

        if (responseMap.size() > 0) {
            return ResponseEntity.status(HttpStatus.CREATED).body(responseMap);
        }
        return null;
    }


    public Instituicao findInstitutionByToken(String token) {
        return instituicaoRepository.findByDsToken(token, 0).get(0);
    }

    public void save(Conta conta) {
        contaRepository.save(conta);
    }

    public ResponseEntity<Object> validateUpdateConta(Conta conta, Integer cdConta) {
        Optional<Conta> contaOptional = findById(cdConta);

        if(contaOptional.isEmpty()){
            responseMap.put("status", HttpStatus.BAD_REQUEST);
            responseMap.put("message", "Not Found");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(responseMap);
        }

        var newConta = contaOptional.get();
        BeanUtils.copyProperties(conta, newConta);
        newConta.setCdConta(cdConta);
        newConta.setInstituicao(contaOptional.get().getInstituicao());

        ResponseEntity<Object> response = validateConta(newConta, newConta.getInstituicao().getDsToken(), cdConta);
        if(response != null) {
            return response;
        }
        save(newConta);
        return null;
    }

    public String oauth(String email, String senha) {
        return contaRepository.getPasswordByEmail(email).equals(senha) ? "authenticated" : "notAuthenticated";
    }
}
