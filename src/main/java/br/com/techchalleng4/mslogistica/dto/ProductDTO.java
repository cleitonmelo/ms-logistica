package br.com.techchalleng4.mslogistica.dto;

import lombok.Builder;

@Builder
public record ProductDTO(
        String code,
        String quantity
) {
}
