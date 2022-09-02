package br.com.fiap.riapi.services;

import br.com.fiap.riapi.domains.Instituicao;
import br.com.fiap.riapi.repository.InstituicaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class InstituicaoService {

    @Autowired
    InstituicaoRepository instituicaoRepository;

    public Page<Instituicao> listAll(Pageable pageable) {
        return instituicaoRepository.findAll(pageable);
    }

    public Optional<Instituicao> findById(Integer id) {
        return instituicaoRepository.findById(id);
    }

    public String save(Instituicao instituicao) {
        if (instituicaoRepository.findByDsEmail(instituicao.getNmInstituicao()).size() > 0) {
            return "duplicated name";
        }else if(instituicaoRepository.findByNrCnpj(instituicao.getNrCnpj()).size() > 0){
            return "duplicated document";
        }else if(instituicaoRepository.findByDsToken(instituicao.getDsToken()).size() > 0){
            return "duplicated Token";
        }
        instituicaoRepository.save(instituicao);
        return "ok";
    }

}
