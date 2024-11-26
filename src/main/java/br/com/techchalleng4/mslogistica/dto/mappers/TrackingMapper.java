package br.com.techchalleng4.mslogistica.dto.mappers;

import br.com.techchalleng4.mslogistica.dto.TrackingDTO;
import br.com.techchalleng4.mslogistica.model.Carrier;
import br.com.techchalleng4.mslogistica.model.Shipping;
import br.com.techchalleng4.mslogistica.model.Tracking;
import lombok.Builder;

import java.util.concurrent.ThreadLocalRandom;

@Builder
public class TrackingMapper {

    public static TrackingDTO toDTO(Tracking tracking) {
        return TrackingDTO.builder()
                .trackingId(tracking.getId())
                .carrier(CarrierMapper.toDTO(tracking.getCarrier()))
                .latitude(tracking.getLatitude())
                .longitude(tracking.getLongitude())
                .build();
    }

    public static Tracking toEntity(Carrier carrier, Shipping shipping) {
        return Tracking.builder()
                .carrier(carrier)
                .shipping(shipping)
                .latitude(getLatitude())
                .longitude(getLongitude())
                .build();
    }

    private static double getLatitude() {
        return ThreadLocalRandom.current().nextDouble(-90.0, 90.0);
    }

    private static double getLongitude() {
        return ThreadLocalRandom.current().nextDouble(-180.0, 180.0);
    }
}
