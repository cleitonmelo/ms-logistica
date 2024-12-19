package br.com.techchalleng4.mslogistica.service.impl;

import br.com.techchalleng4.mslogistica.dto.CarrierDTO;
import br.com.techchalleng4.mslogistica.dto.mappers.CarrierMapper;
import br.com.techchalleng4.mslogistica.model.Carrier;
import br.com.techchalleng4.mslogistica.repository.CarrierRepository;
import br.com.techchalleng4.mslogistica.service.CarrierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class CarrierServiceImpl implements CarrierService {

    private final CarrierRepository carrierRepository;

    @Autowired
    public CarrierServiceImpl(CarrierRepository carrierRepository) {
        this.carrierRepository = carrierRepository;
    }

    @Override
    public Page<CarrierDTO> all(Pageable pageable) {
        Page<Carrier> carriers = carrierRepository.findAll(pageable);
        return carriers.map(CarrierMapper::toDTO);
    }
}
