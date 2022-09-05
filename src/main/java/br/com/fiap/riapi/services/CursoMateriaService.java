package br.com.fiap.riapi.services;

import br.com.fiap.riapi.domains.CursoMateria;
import br.com.fiap.riapi.repository.CursoMateriaRepository;
import br.com.fiap.riapi.repository.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CursoMateriaService {

    @Autowired
    CursoMateriaRepository cursoMateriaRepository;
    @Autowired
    CursoService cursoService;
    @Autowired
    MateriaService materiaService;

    public Page<CursoMateria> listAll(Pageable pageable) {
        return cursoMateriaRepository.findAll(pageable);
    }

    public Optional<CursoMateria> findById(Integer cdCursoMateria) {
        return cursoMateriaRepository.findById(cdCursoMateria);
    }

    public void create(CursoMateria cursoMateria) {
        cursoMateriaRepository.save(cursoMateria);
    }

    public void delete(Integer cdCursoMateria) {
        cursoMateriaRepository.deleteById(cdCursoMateria);
    }
}
