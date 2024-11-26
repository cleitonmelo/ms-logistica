package br.com.techchalleng4.mslogistica.dto;

import br.com.techchalleng4.mslogistica.model.Address;
import br.com.techchalleng4.mslogistica.model.Carrier;
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
