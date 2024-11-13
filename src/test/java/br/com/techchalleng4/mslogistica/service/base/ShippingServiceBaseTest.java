package br.com.techchalleng4.mslogistica.service.base;

import br.com.techchalleng4.mslogistica.dto.AddressDTO;
import br.com.techchalleng4.mslogistica.dto.ProductDTO;
import br.com.techchalleng4.mslogistica.dto.ShippingDTO;
import jakarta.persistence.GeneratedValue;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public abstract class ShippingServiceBaseTest {

    public ShippingDTO createShippingDTO()
    {
        return ShippingDTO.builder()
                .id(UUID.randomUUID())
                .recipient("Pedido de teste")
                .orderCode("XYZ0091991")
                .products(listProducts())
                .address(getAddress())
                .build();
    }

    private List<ProductDTO> listProducts()
    {
        List<ProductDTO> products = new ArrayList<>();
        products.add(ProductDTO.builder().code("1").name("Produto de Teste").build());
        products.add(ProductDTO.builder().code("2").name("Produto de Teste 02").build());
        return products;
    }

    private AddressDTO getAddress()
    {
        return AddressDTO.builder()
                .street("Rua de teste")
                .number(123)
                .neighborhood("Bairro de teste")
                .city("Santo Andre")
                .state("SP")
                .country("Brasil")
                .build();
    }

}
