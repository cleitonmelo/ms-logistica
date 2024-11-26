package br.com.techchalleng4.mslogistica.dto;

import lombok.Builder;

@Builder
public record CarrierDTO(
        Integer code,
        String name,
        Integer zipCodeStart,
        Integer zipCodeEnd
) {
}
