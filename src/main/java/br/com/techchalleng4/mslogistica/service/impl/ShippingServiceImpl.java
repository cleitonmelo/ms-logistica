package br.com.techchalleng4.mslogistica.service.impl;

import br.com.techchalleng4.mslogistica.dto.AddressDTO;
import br.com.techchalleng4.mslogistica.dto.ProductDTO;
import br.com.techchalleng4.mslogistica.dto.ShippingDTO;
import br.com.techchalleng4.mslogistica.dto.mappers.AddressMapper;
import br.com.techchalleng4.mslogistica.dto.mappers.ProductMapper;
import br.com.techchalleng4.mslogistica.dto.mappers.ShippingMapper;
import br.com.techchalleng4.mslogistica.model.Address;
import br.com.techchalleng4.mslogistica.model.Product;
import br.com.techchalleng4.mslogistica.model.Shipping;
import br.com.techchalleng4.mslogistica.repository.AddressRepository;
import br.com.techchalleng4.mslogistica.repository.ProductRepository;
import br.com.techchalleng4.mslogistica.repository.ShippingRepository;
import br.com.techchalleng4.mslogistica.service.ShippingService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ShippingServiceImpl implements ShippingService {

    @Autowired
    private final ShippingRepository shippingRepository;

    @Autowired
    private final ProductRepository productRepository;

    @Autowired
    private final AddressRepository addressRepository;

    @Override
    public ShippingDTO create(ShippingDTO shippingDTO) {
        Shipping shipping = shippingRepository.save(
                ShippingMapper.toEntity(shippingDTO)
        );

        if (shipping.getId() != null){
            shipping.setShippingAddress(saveAddress(shippingDTO.address(), shipping));
            shipping.setProducts(saveProducts(shippingDTO.products(), shipping));
        }

        return ShippingMapper.toDTO(shipping);
    }

    private Address saveAddress(AddressDTO addresses, Shipping shipping) {
        return addressRepository.save(AddressMapper.toEntity(addresses, shipping));
    }

    private List<Product> saveProducts(List<ProductDTO> products, Shipping shipping) {
        List<Product> newProducts = new ArrayList<>();
        for (ProductDTO product : products) {
            Product entity = ProductMapper.toEntity(product, shipping);
            productRepository.save(entity);
            newProducts.add(entity);
        }
        return newProducts;
    }

    @Override
    public Page<ShippingDTO> get(Pageable pageable) {
        Page<Shipping> shippings = shippingRepository.findAll(pageable);
        return shippings.map(ShippingMapper::toDTO);
    }
}
