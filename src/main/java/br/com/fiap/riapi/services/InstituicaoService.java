package br.com.fiap.riapi.services;

import br.com.fiap.riapi.domains.Instituicao;
import br.com.fiap.riapi.repository.InstituicaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import java.util.Optional;

@Service
public class InstituicaoService {

    @Autowired
    InstituicaoRepository instituicaoRepository;
    private EntityManager session;

    public Page<Instituicao> listAll(Pageable pageable) {
        return instituicaoRepository.findAll(pageable);
    }

    public Optional<Instituicao> findById(Integer id) {
        return instituicaoRepository.findById(id);
    }

    public String save(Instituicao instituicao) {
        if(findByName(instituicao.getNmInstituicao())){
            System.out.println("teste");
        }
        instituicaoRepository.save(instituicao);
        return "ok";
    }

    public boolean findByName(String nmInstituicao) {
        var query = session.createQuery("from Instituicao where nmInstituicao like :nmInstituicao");
        query.setParameter("nmInstituicao", nmInstituicao);
        return query.getResultList().size() <= 0;
    }
}
