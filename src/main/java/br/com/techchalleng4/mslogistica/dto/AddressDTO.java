package br.com.techchalleng4.mslogistica.dto;

import lombok.Builder;

@Builder
public record AddressDTO(
        String street,
        Integer number,
        String complement,
        String city,
        String neighborhood,
        String state,
        Integer zip,
        String country,
        String phone
) {
}
