package br.com.techchalleng4.mslogistica.dto.mappers;

import br.com.techchalleng4.mslogistica.dto.TrackingDTO;
import br.com.techchalleng4.mslogistica.model.Carrier;
import br.com.techchalleng4.mslogistica.model.Shipping;
import br.com.techchalleng4.mslogistica.model.Tracking;
import lombok.Builder;

@Builder
public class TrackingMapper {

    public static TrackingDTO toDTO(Tracking tracking) {
        return TrackingDTO.builder()
                .trackingId(tracking.getId())
                .shipping(ShippingMapper.toDTO(tracking.getShipping()))
                .carrier(CarrierMapper.toDTO(tracking.getCarrier()))
                .latitude(tracking.getLatitude())
                .longitude(tracking.getLongitude())
                .build();
    }

    public static Tracking toEntity(Carrier carrier, Shipping shipping) {
        return Tracking.builder()
                .carrier(carrier)
                .shipping(shipping)
                .latitude(22.718285)
                .longitude(-47.353609)
                .build();
    }
}
