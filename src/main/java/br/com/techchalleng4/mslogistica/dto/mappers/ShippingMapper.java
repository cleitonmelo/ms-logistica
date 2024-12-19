package br.com.techchalleng4.mslogistica.dto.mappers;

import br.com.techchalleng4.mslogistica.dto.ShippingDTO;
import br.com.techchalleng4.mslogistica.enums.ShippingStatus;
import br.com.techchalleng4.mslogistica.model.Product;
import br.com.techchalleng4.mslogistica.model.Shipping;
import lombok.Builder;

import java.util.ArrayList;
import java.util.List;

@Builder
public class ShippingMapper {

    private ShippingMapper(){
        throw new IllegalStateException("Utility class");
    }

    public static ShippingDTO toDTO(Shipping shipping) {
        List<Product> products = new ArrayList<>();

        for (Product product : shipping.getProducts()) {
            Product children = new Product();
            children.setId(product.getId());
            children.setQuantity(product.getQuantity());
            children.setCode(product.getCode());
            products.add(children);
        }

        return ShippingDTO.builder()
                .id(shipping.getId())
                .orderCode(shipping.getOrderCode())
                .recipient(shipping.getRecipient())
                .status(shipping.getStatus().getDescription())
                .address(AddressMapper.toDTO(shipping.getShippingAddress()))
                .shippingDate(shipping.getShippingDate())
                .deliveryDate(shipping.getDeliveryDate())
                .products(products.stream().map(ProductMapper::toDTO).toList())
                .tracking(shipping.getShippingTracking() != null ? TrackingMapper.toDTO(shipping.getShippingTracking()) : null)
                .build();
    }

    public static Shipping toEntity(ShippingDTO shippingDTO) {
        return Shipping.builder()
                .id(shippingDTO.id())
                .orderCode(shippingDTO.orderCode())
                .status(ShippingStatus.ORDER_RECEIVED)
                .recipient(shippingDTO.recipient())
                .build();
    }
}
