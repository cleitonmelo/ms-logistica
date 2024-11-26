package br.com.techchalleng4.mslogistica.dto.mappers;

import br.com.techchalleng4.mslogistica.dto.TrackingDTO;
import br.com.techchalleng4.mslogistica.model.Carrier;
import br.com.techchalleng4.mslogistica.model.Tracking;
import lombok.Builder;

@Builder
public class TrackingMapper {

    public static TrackingDTO toDTO(Tracking tracking) {
        return TrackingDTO.builder()
                .trackingId(tracking.getId())
                .shipping(tracking.getShipping())
                .carrier(tracking.getCarrier())
                .latitude(tracking.getLatitude())
                .longitude(tracking.getLongitude())
                .build();
    }

    public static Tracking toEntity(TrackingDTO trackingDTO) {
        return Tracking.builder()
                .id(trackingDTO.trackingId())
                .carrier(trackingDTO.carrier())
                .shipping(trackingDTO.shipping())
                .latitude(trackingDTO.latitude())
                .longitude(trackingDTO.longitude())
                .build();
    }
}
