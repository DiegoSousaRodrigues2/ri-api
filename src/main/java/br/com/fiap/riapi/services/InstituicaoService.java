package br.com.fiap.riapi.services;

import br.com.fiap.riapi.domains.Instituicao;
import br.com.fiap.riapi.repository.InstituicaoRepository;
import org.jetbrains.annotations.NotNull;
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
public class InstituicaoService {

    @Autowired
    InstituicaoRepository instituicaoRepository;

    Map<String, Object> responseMap = new HashMap<>();

    public Page<Instituicao> listAll(Pageable pageable) {
        return instituicaoRepository.findAll(pageable);
    }

    public Optional<Instituicao> findById(Integer id) {
        return instituicaoRepository.findById(id);
    }

    public void save(Instituicao instituicao){
        instituicaoRepository.save(instituicao);
    }

    public ResponseEntity<Object> validateIntituicao(@NotNull Instituicao instituicao) {
        if (instituicaoRepository.findByNmInstituicao(instituicao.getNmInstituicao()).size() > 0) {
            responseMap.put("status", HttpStatus.BAD_REQUEST);
            responseMap.put("message", "duplicated name");
        } else if (instituicaoRepository.findByNrCnpj(instituicao.getNrCnpj()).size() > 0) {
            responseMap.put("status", HttpStatus.BAD_REQUEST);
            responseMap.put("message", "duplicated document");
        } else if (instituicaoRepository.findByDsToken(instituicao.getDsToken()).size() > 0) {
            responseMap.put("status", HttpStatus.BAD_REQUEST);
            responseMap.put("message", "duplicated Token");
        } else {
            responseMap.clear();
        }

        if(responseMap.size() > 0){
            return ResponseEntity.status(HttpStatus.CREATED).body(responseMap);
        }

        //TODO criar metodo para validar CNPJ

        return null;
    }

    public ResponseEntity<Object> validateIntituicaoUpdate(@NotNull Instituicao instituicao, Integer id) {
        if (instituicao.getCdInstituicao() != null) {
            responseMap.put("status", HttpStatus.BAD_REQUEST);
            responseMap.put("message", "automatically generated id");
            return ResponseEntity.status(HttpStatus.CREATED).body(responseMap);
        }

        Optional<Instituicao> instituicaoOptional = findById(id);

        if (instituicaoOptional.isEmpty()) {
            responseMap.put("status", HttpStatus.BAD_REQUEST);
            responseMap.put("message", "Not Found");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(responseMap);
        }

        var newInstituicao = instituicaoOptional.get();
        BeanUtils.copyProperties(instituicao, newInstituicao);
        newInstituicao.setCdInstituicao(id);

        ResponseEntity<Object> response = validateIntituicao(newInstituicao);
        if(response != null) {
            return response;
        }

        save(newInstituicao);
        return null;
    }

    public ResponseEntity<Object> deleteById(Integer id) {

        Optional<Instituicao> instituicao = findById(id);

        if (instituicao.isEmpty()) {
            responseMap.put("status", HttpStatus.BAD_REQUEST);
            responseMap.put("message", "Not Found");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(responseMap);
        }

        instituicaoRepository.deleteById(id);

        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();

    }
}
