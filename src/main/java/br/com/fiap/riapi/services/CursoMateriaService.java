package br.com.fiap.riapi.services;

import br.com.fiap.riapi.domains.Curso;
import br.com.fiap.riapi.domains.CursoMateria;
import br.com.fiap.riapi.domains.Materia;
import br.com.fiap.riapi.repository.CursoMateriaRepository;
import br.com.fiap.riapi.repository.CursoRepository;
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
public class CursoMateriaService {

    @Autowired
    CursoMateriaRepository cursoMateriaRepository;
    @Autowired
    CursoService cursoService;
    @Autowired
    MateriaService materiaService;

    Map<String, Object> responseMap = new HashMap<>();

    public Page<CursoMateria> listAll(Pageable pageable) {
        return cursoMateriaRepository.findAll(pageable);
    }

    public Optional<CursoMateria> findById(Integer cdCursoMateria) {
        return cursoMateriaRepository.findById(cdCursoMateria);
    }

    public void save(CursoMateria cursoMateria) {
        cursoMateriaRepository.save(cursoMateria);
    }

    public void delete(Integer cdCursoMateria) {
        cursoMateriaRepository.deleteById(cdCursoMateria);
    }

    public ResponseEntity<Object> associarMateriaCurso(Materia materia, Integer cdCurso) {
        Optional<Curso> curso = cursoService.findById(cdCurso);
        if(curso.isEmpty()){
            responseMap.put("status", HttpStatus.NOT_FOUND);
            responseMap.put("message", "Curso not found");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(responseMap);
        }

        CursoMateria cursoMateria = new CursoMateria(materia, curso.get());

        save(cursoMateria);

        return ResponseEntity.status(HttpStatus.OK).body(cursoMateria);
    }
}
