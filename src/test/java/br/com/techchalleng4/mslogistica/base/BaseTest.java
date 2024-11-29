package br.com.techchalleng4.mslogistica.base;

import br.com.techchalleng4.mslogistica.dto.AddressDTO;
import br.com.techchalleng4.mslogistica.dto.ProductDTO;
import br.com.techchalleng4.mslogistica.dto.ShippingDTO;

import java.util.ArrayList;
import java.util.List;

public abstract class BaseTest {

    public String URI;

    public static final String BASE_API = "/api/v1";

    public String getBaseUri()
    {
        return BASE_API + "/" + URI;
    }

    public static AddressDTO getAddressDTO(){
        return AddressDTO.builder()
                .street("Teste")
                .phone("19991238899")
                .number(123)
                .neighborhood("Teste")
                .state("SP")
                .city("Americana")
                .country("Brazil")
                .zipCode(13470160)
                .complement("Complemento de Teste")
                .build();
    };


    public static List<ProductDTO> getListProducts(){
        List<ProductDTO> products = new ArrayList<>();

        products.add(ProductDTO.builder()
                .code("TESTE000001")
                .quantity("1")
                .build());

        products.add(ProductDTO.builder()
                .code("TESTE000002")
                .quantity("1")
                .build());

        products.add(ProductDTO.builder()
                .code("TESTE000003")
                .quantity("1")
                .build());
        return products;
    }

    public static ShippingDTO getShippingDtoForInsert(){
        return ShippingDTO.builder()
                .orderCode("TST-000012")
                .shippingDate(null)
                .recipient("Teste")
                .address(getAddressDTO())
                .products(getListProducts())
                .build();
    }
}
