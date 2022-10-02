package br.com.fiap.riapi.services;

import br.com.fiap.riapi.domains.Curso;
import br.com.fiap.riapi.repository.CursoRepository;
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
public class CursoService {

    @Autowired
    CursoRepository cursoRepository;

    Map<String, Object> responseMap = new HashMap<>();

    public Optional<Curso> findById(Integer cdCurso) {
        return cursoRepository.findById(cdCurso);
    }

    public Page<Curso> listAll(Pageable pageable) {
        return cursoRepository.findAll(pageable);
    }

    public ResponseEntity<Object> validateCurso(Curso curso) {
        if(curso.getNmCurso() == null){
            responseMap.put("status", HttpStatus.BAD_REQUEST);
            responseMap.put("message", "invalid name");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseMap);
        } else if(curso.getNmPeriodo() == null){
            responseMap.put("status", HttpStatus.BAD_REQUEST);
            responseMap.put("message", "invalid periodo");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseMap);
        }

        return null;
    }

    public void save(Curso curso) {
        cursoRepository.save(curso);
    }

    public ResponseEntity<Object> update(Curso curso, Integer cdCurso) {
        Optional<Curso> cursoOptional = findById(cdCurso);
        if(cursoOptional.isEmpty()){
            responseMap.put("status", HttpStatus.NOT_FOUND);
            responseMap.put("message", "not found");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(responseMap);
        }

        var newCurso = cursoOptional.get();
        BeanUtils.copyProperties(curso, newCurso);
        newCurso.setCdCurso(cdCurso);

        save(newCurso);
        return null;
    }

    public void deletedById(Integer cdCurso) {
        cursoRepository.deleteById(cdCurso);
    }
}
