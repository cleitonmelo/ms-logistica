package br.com.techchalleng4.mslogistica.dto;

import br.com.techchalleng4.mslogistica.model.Carrier;
import br.com.techchalleng4.mslogistica.model.Shipping;
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
