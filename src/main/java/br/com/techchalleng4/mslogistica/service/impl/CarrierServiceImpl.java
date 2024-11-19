package br.com.techchalleng4.mslogistica.service.impl;

import br.com.techchalleng4.mslogistica.dto.CarrierDTO;
import br.com.techchalleng4.mslogistica.model.Carrier;
import br.com.techchalleng4.mslogistica.service.CarrierService;

import java.util.List;

public class CarrierServiceImpl implements CarrierService {

    @Override
    public List<CarrierDTO> getByPostCodeInterval(Integer start, Integer end) {
        return List.of();
    }
}
