package br.com.techchalleng4.mslogistica.dto;

import lombok.Builder;

import java.util.UUID;

@Builder
public record TrackingDTO(
        UUID trackingId,
        Double latitude,
        Double longitude,
        CarrierDTO carrier
) {
}
