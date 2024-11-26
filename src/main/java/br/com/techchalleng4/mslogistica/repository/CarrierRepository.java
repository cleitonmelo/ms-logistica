package br.com.techchalleng4.mslogistica.repository;

import br.com.techchalleng4.mslogistica.model.Carrier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CarrierRepository extends JpaRepository<Carrier, Integer> {

    @Query("SELECT code, name FROM Carrier WHERE zipCodeStart < :zipCode AND zipCodeEnd >= :zipCode")
    List<Carrier> findByZipCode(@Param("zipCode") String zipCode);

}
