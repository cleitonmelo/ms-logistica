package br.com.techchalleng4.mslogistica.service;

import br.com.techchalleng4.mslogistica.dto.CarrierDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CarrierService {

    Page<CarrierDTO> all(Pageable pageable);


}
