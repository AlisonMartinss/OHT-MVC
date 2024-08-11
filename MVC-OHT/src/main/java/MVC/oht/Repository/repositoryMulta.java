package MVC.oht.Repository;

import MVC.oht.EntityJPA.entityMulta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface repositoryMulta extends JpaRepository<entityMulta,String> {

    @Query(nativeQuery = true,
            value = "SELECT * FROM informacoes_cidadao WHERE CPF = :CPF")
    List<entityMulta> findByCPF(@Param("CPF") String cpf);

    @Query(nativeQuery = true,
            value = "SELECT * FROM informacoes_cidadao CPF = :CPF AND SITUACAO = :SITU" )
    List<entityMulta>findBySituacao(@Param("CPF") String cpf, @Param("SITU") String situacao);

}
