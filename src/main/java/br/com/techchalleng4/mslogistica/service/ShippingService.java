package br.com.techchalleng4.mslogistica.service;

import br.com.techchalleng4.mslogistica.dto.ShippingDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ShippingService {

    ShippingDTO create(ShippingDTO shippingDTO);
    Page<ShippingDTO> getAll(Pageable pageable);
    void finished(String shippingId);
    ShippingDTO get(String shippingId);
    void process();
}
