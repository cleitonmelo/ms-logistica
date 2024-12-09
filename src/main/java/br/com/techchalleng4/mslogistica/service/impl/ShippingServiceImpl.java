package br.com.techchalleng4.mslogistica.service.impl;

import br.com.techchalleng4.mslogistica.dto.AddressDTO;
import br.com.techchalleng4.mslogistica.dto.ProductDTO;
import br.com.techchalleng4.mslogistica.dto.ShippingDTO;
import br.com.techchalleng4.mslogistica.dto.TrackingDTO;
import br.com.techchalleng4.mslogistica.dto.mappers.AddressMapper;
import br.com.techchalleng4.mslogistica.dto.mappers.ProductMapper;
import br.com.techchalleng4.mslogistica.dto.mappers.ShippingMapper;
import br.com.techchalleng4.mslogistica.dto.mappers.TrackingMapper;
import br.com.techchalleng4.mslogistica.enums.ShippingStatus;
import br.com.techchalleng4.mslogistica.model.*;
import br.com.techchalleng4.mslogistica.repository.*;
import br.com.techchalleng4.mslogistica.service.CarrierService;
import br.com.techchalleng4.mslogistica.service.ShippingService;
import br.com.techchalleng4.mslogistica.service.TrackingService;
import jakarta.persistence.GeneratedValue;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ShippingServiceImpl implements ShippingService {

    @Autowired
    private final ShippingRepository shippingRepository;

    @Autowired
    private final ProductRepository productRepository;

    @Autowired
    private final AddressRepository addressRepository;

    @Autowired
    private final CarrierRepository carrierRepository;

    @Autowired
    private final TrackingRepository trackingRepository;

    @Override
    public ShippingDTO create(ShippingDTO shippingDTO) {
        Shipping shipping = shippingRepository.save(
                ShippingMapper.toEntity(shippingDTO)
        );

        shipping.setShippingAddress(saveAddress(shippingDTO.address(), shipping));
        shipping.setProducts(saveProducts(shippingDTO.products(), shipping));

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
    public Page<ShippingDTO> getAll(Pageable pageable) {
        Page<Shipping> shippings = shippingRepository.findAll(pageable);
        return shippings.map(ShippingMapper::toDTO);
    }

    @Override
    public void finished(String shippingId) {
        Shipping shipping = shippingRepository
                .findById(UUID.fromString(shippingId)).orElse(null);

        if ( shipping != null ){
            shipping.setStatus(ShippingStatus.OrderDelivered);
            shipping.setDeliveryDate(LocalDate.now());
            shippingRepository.save(shipping);
        }
    }

    @Override
    public ShippingDTO get(String shippingId) {
        Shipping shipping = shippingRepository
                .findById(UUID.fromString(shippingId)).orElse(null);
        return shipping != null ? ShippingMapper.toDTO(shipping) : null;
    }

    @Override
    public void process() {
        List<Shipping> shippings = shippingRepository.findByStatus(ShippingStatus.OrderReceived);
        for (Shipping shipping : shippings) {

            if ( shipping.getShippingAddress().getZipCode() != null ){
                Carrier carrier = carrierRepository.findByZipCode(
                        shipping.getShippingAddress().getZipCode()
                );
                shipping.setShippingDate(LocalDate.now());
                saveTracking(carrier, shipping);
                shipping.setStatus(ShippingStatus.WithOrderCarrier);
                shippingRepository.save(shipping);
            }
        }
    }

    private Tracking saveTracking(Carrier carrier, Shipping shipping) {
        return trackingRepository.save(TrackingMapper.toEntity(carrier,shipping));
    }
}
