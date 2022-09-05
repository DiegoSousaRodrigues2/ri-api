package br.com.fiap.riapi.services;

import br.com.fiap.riapi.domains.Curso;
import br.com.fiap.riapi.domains.Materia;
import br.com.fiap.riapi.repository.MateriaRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
public class MateriaService {

    @Autowired
    MateriaRepository materiaRepository;

    Map<String, Object> responseMap = new HashMap<>();

    public Optional<Materia> findById(Integer cdMateria) {
        return materiaRepository.findById(cdMateria);
    }

    public Page<Materia> listAll(Pageable pageable) {
        return materiaRepository.findAll(pageable);
    }

    public void save(Materia materia) {
        materiaRepository.save(materia);
    }

    public void delete(Integer cdMateria) {
        materiaRepository.deleteById(cdMateria);
    }

    public ResponseEntity<Object> update(Materia materia, Integer cdMateria) {
        Optional<Materia> materiaOptional = findById(cdMateria);

        if(materiaOptional.isEmpty()){
            responseMap.put("status", HttpStatus.NOT_FOUND);
            responseMap.put("message", "not found");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(responseMap);
        }

        var newMateria = materiaOptional.get();
        BeanUtils.copyProperties(materia, newMateria);
        newMateria.setCdMateria(cdMateria);

        save(newMateria);
        return null;
    }
}
