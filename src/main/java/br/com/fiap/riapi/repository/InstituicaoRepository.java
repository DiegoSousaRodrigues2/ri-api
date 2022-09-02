package br.com.fiap.riapi.repository;

import br.com.fiap.riapi.domains.Instituicao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Collection;
import java.util.List;

public interface InstituicaoRepository extends JpaRepository<Instituicao, Integer> {

    @Query(value = "select i from Instituicao i where i.nmInstituicao = ?1")
    List<Instituicao> findByNmInstituicao(String nmInstituicao);

    @Query(value = "select i from Instituicao i where i.nrCnpj = ?1")
    List<Instituicao> findByNrCnpj(String nrCnpj);

    @Query(value = "select i from Instituicao i where i.dsToken = ?1")
    List<Instituicao> findByDsToken(String dsToken);

}
