package br.com.techchalleng4.mslogistica.dto;

import br.com.techchalleng4.mslogistica.model.Address;
import lombok.Builder;

import java.util.List;
import java.util.UUID;

@Builder
public record ShippingDTO(
        UUID id,
        String orderCode,
        String recipient,
        String status,
        AddressDTO address,
        List<ProductDTO> products
){}
