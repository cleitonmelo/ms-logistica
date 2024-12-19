package br.com.techchalleng4.mslogistica.dto.mappers;

import br.com.techchalleng4.mslogistica.dto.CarrierDTO;
import br.com.techchalleng4.mslogistica.model.Carrier;

public class CarrierMapper {

    private CarrierMapper() {
        throw new IllegalStateException("Utility class");
    }

    public static CarrierDTO toDTO(Carrier carrier) {
        return CarrierDTO.builder()
                .code(carrier.getCode())
                .name(carrier.getName())
                .zipCodeStart(carrier.getZipCodeStart())
                .zipCodeEnd(carrier.getZipCodeEnd())
                .build();
    }

    public static Carrier toEntity(Carrier carrier) {
        return Carrier.builder()
                .code(carrier.getCode())
                .name(carrier.getName())
                .zipCodeEnd(carrier.getZipCodeEnd())
                .zipCodeEnd(carrier.getZipCodeStart())
                .build();
    }
}
