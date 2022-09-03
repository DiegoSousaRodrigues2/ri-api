package br.com.fiap.riapi.repository;

import br.com.fiap.riapi.domains.Conta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ContaRepository extends JpaRepository<Conta, Integer> {

    @Query("select c from Conta c where c.dsEmail = ?1 and c.cdConta <> ?2")
    List<Conta> findByDsEmail(String dsEmail, Integer cdConta);

    @Query("select c.cdConta,c.dsDocumento from Conta c where c.dsDocumento = ?1 and c.cdConta <> ?2")
    List<Conta> findByDsDocumento(String document, Integer cdConta);

}
