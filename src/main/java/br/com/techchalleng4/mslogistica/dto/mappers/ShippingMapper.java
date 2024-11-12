package br.com.techchalleng4.mslogistica.dto.mappers;

import br.com.techchalleng4.mslogistica.dto.AddressDTO;
import br.com.techchalleng4.mslogistica.dto.ShippingDTO;
import br.com.techchalleng4.mslogistica.enums.ShippingStatus;
import br.com.techchalleng4.mslogistica.model.Product;
import br.com.techchalleng4.mslogistica.model.Shipping;
import lombok.Builder;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Builder
public class ShippingMapper {

    public static ShippingDTO toDTO(Shipping shipping) {
        List<Product> products = new ArrayList<>();

        for (Product product : shipping.getProducts()) {
            Product children = new Product();
            children.setId(product.getId());
            children.setName(product.getName());
            children.setCode(product.getCode());
            products.add(children);
        }

        return ShippingDTO.builder()
                .id(shipping.getId())
                .orderCode(shipping.getOrderCode())
                .recipient(shipping.getRecipient())
                .status(shipping.getStatus().getDescription())
                .address(AddressMapper.toDTO(shipping.getShippingAddress()))
                .products(products.stream().map(ProductMapper::toDTO).collect(Collectors.toList()))
                .build();
    }

    public static Shipping toEntity(ShippingDTO shippingDTO) {
        return Shipping.builder()
                .id(shippingDTO.id())
                .orderCode(shippingDTO.orderCode())
                .status(ShippingStatus.OrderReceived)
                .recipient(shippingDTO.recipient())
                .build();
    }
}
