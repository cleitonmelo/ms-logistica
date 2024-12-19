package br.com.techchalleng4.mslogistica.dto;

import lombok.Builder;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Builder
public record ShippingDTO(
        UUID id,
        String orderCode,
        String recipient,
        String status,
        LocalDate shippingDate,
        LocalDate deliveryDate,
        TrackingDTO tracking,
        AddressDTO address,
        List<ProductDTO> products
){}
