package br.com.fiap.riapi.repository;

import br.com.fiap.riapi.domains.Instituicao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

public interface InstituicaoRepository extends JpaRepository<Instituicao, Integer> {

    @Query(value = "select i from Instituicao i where i.nmInstituicao = ?1 and i.cdInstituicao <> ?2")
    List<Instituicao> findByNmInstituicao(String nmInstituicao, Integer cdIntituicao);

    @Query(value = "select i from Instituicao i where i.nrCnpj = ?1 and i.cdInstituicao <> ?2")
    List<Instituicao> findByNrCnpj(String nrCnpj, Integer cdIntituicao);

    @Query(value = "select i from Instituicao i where i.dsToken = ?1 and i.cdInstituicao <> ?2")
    List<Instituicao> findByDsToken(String dsToken, Integer cdIntituicao);

}
