package br.com.techchalleng4.mslogistica.service.impl;

import br.com.techchalleng4.mslogistica.dto.ShippingDTO;
import br.com.techchalleng4.mslogistica.dto.mappers.ShippingMapper;
import br.com.techchalleng4.mslogistica.model.Shipping;
import br.com.techchalleng4.mslogistica.repository.ShippingRepository;
import br.com.techchalleng4.mslogistica.service.ShippingService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ShippingServiceImpl implements ShippingService {

    @Autowired
    private final ShippingRepository shippingRepository;

    @Override
    public ShippingDTO create(ShippingDTO shippingDTO) {
        Shipping shipping = shippingRepository.save(
                ShippingMapper.toEntity(shippingDTO)
        );
        return ShippingMapper.toDTO(shipping);
    }

    @Override
    public Page<ShippingDTO> get(Pageable pageable) {
        Page<Shipping> shippings = shippingRepository.findAll(pageable);
        return shippings.map(ShippingMapper::toDTO);
    }
}
