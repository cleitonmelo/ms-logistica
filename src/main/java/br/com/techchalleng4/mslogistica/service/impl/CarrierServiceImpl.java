package br.com.techchalleng4.mslogistica.service.impl;

import br.com.techchalleng4.mslogistica.model.Carrier;
import br.com.techchalleng4.mslogistica.repository.CarrierRepository;
import br.com.techchalleng4.mslogistica.service.CarrierService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CarrierServiceImpl implements CarrierService {

    @Autowired
    private final CarrierRepository carrierRepository;

    public Carrier findByZipCode(Integer zipCode) {
        return carrierRepository.findByZipCode(zipCode);
    }
}
