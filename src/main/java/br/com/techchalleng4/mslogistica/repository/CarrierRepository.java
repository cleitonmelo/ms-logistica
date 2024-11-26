package br.com.techchalleng4.mslogistica.repository;

import br.com.techchalleng4.mslogistica.model.Carrier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CarrierRepository extends JpaRepository<Carrier, Integer> {

    @Query(value = "SELECT * FROM CARRIERS WHERE ZIP_CODE_START < :zipCode AND ZIP_CODE_END >= :zipCode LIMIT 1",
            nativeQuery = true)
    Carrier findByZipCode(@Param("zipCode") Integer zipCode);

}
