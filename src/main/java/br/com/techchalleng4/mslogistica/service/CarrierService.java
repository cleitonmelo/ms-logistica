package br.com.techchalleng4.mslogistica.service;

import br.com.techchalleng4.mslogistica.model.Carrier;

import java.util.List;

public interface CarrierService {

    Carrier findByZipCode(Integer zipCode);
}
