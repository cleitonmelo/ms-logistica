package br.com.techchalleng4.mslogistica.service;

import br.com.techchalleng4.mslogistica.dto.CarrierDTO;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CarrierService {

    @Query("SELECT c FROM carriers c WHERE c.cep_start >= :start AND c.cep_end <= :end" )
    List<CarrierDTO> getByPostCodeInterval(@Param("start") Integer start, @Param("end") Integer end);
}
