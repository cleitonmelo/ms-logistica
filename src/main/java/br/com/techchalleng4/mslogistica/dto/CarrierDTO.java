package br.com.techchalleng4.mslogistica.dto;

import lombok.Builder;

@Builder
public record CarrierDTO(
        Long code,
        String name,
        Integer zipCodeStart,
        Integer zipCodeEnd
) {
}
