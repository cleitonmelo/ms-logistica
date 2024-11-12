package br.com.techchalleng4.mslogistica.service;

import br.com.techchalleng4.mslogistica.dto.ShippingDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ShippingService {

    ShippingDTO create(ShippingDTO shippingDTO);
    Page<ShippingDTO> get(Pageable pageable);
}
