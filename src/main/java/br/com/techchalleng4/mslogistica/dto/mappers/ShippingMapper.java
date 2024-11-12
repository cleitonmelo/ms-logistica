package br.com.techchalleng4.mslogistica.dto.mappers;

import br.com.techchalleng4.mslogistica.dto.ShippingDTO;
import br.com.techchalleng4.mslogistica.enums.ShippingStatus;
import br.com.techchalleng4.mslogistica.model.Shipping;
import lombok.Builder;

@Builder
public class ShippingMapper {

    public static ShippingDTO toDTO(Shipping shipping) {
        return ShippingDTO.builder()
                .id(shipping.getId())
                .orderCode(shipping.getOrderCode())
                .recipient(shipping.getRecipient())
                .status(shipping.getStatus().getDescription())
                .zipCode(shipping.getZipCode())
                .build();
    }

    public static Shipping toEntity(ShippingDTO shippingDTO) {
        return Shipping.builder()
                .id(shippingDTO.id())
                .orderCode(shippingDTO.orderCode())
                .zipCode(shippingDTO.zipCode())
                .status(ShippingStatus.OrderReceived)
                .recipient(shippingDTO.recipient())
                .build();

        /*return new Shipping(
                shippingDTO.id(),
                shippingDTO.orderCode(),
                shippingDTO.recipient(),
                ShippingStatus.OrderReceived,
                shippingDTO.zipCode()
        );*/
    }
}
