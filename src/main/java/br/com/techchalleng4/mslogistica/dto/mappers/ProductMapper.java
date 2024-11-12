package br.com.techchalleng4.mslogistica.dto.mappers;

import br.com.techchalleng4.mslogistica.dto.ProductDTO;
import br.com.techchalleng4.mslogistica.model.Product;
import br.com.techchalleng4.mslogistica.model.Shipping;
import lombok.Builder;

@Builder
public class ProductMapper {

    public static ProductDTO toDTO(Product product) {
        return ProductDTO.builder()
                .code(product.getCode())
                .name(product.getName()).build();
    }

    public static Product toEntity(ProductDTO produtoDTO, Shipping shipping) {
        return Product.builder()
                .code(produtoDTO.code())
                .name(produtoDTO.name())
                .shipping(shipping)
                .build();
    }
}
