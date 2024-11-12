package br.com.techchalleng4.mslogistica.dto;

import br.com.techchalleng4.mslogistica.enums.ShippingStatus;
import lombok.Builder;

import java.util.UUID;

@Builder
public record ShippingDTO(
        UUID id,
        String orderCode,
        String recipient,
        String status,
        String zipCode
){}
