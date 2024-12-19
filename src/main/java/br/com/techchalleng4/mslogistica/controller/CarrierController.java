package br.com.techchalleng4.mslogistica.controller;

import br.com.techchalleng4.mslogistica.dto.CarrierDTO;
import br.com.techchalleng4.mslogistica.service.CarrierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/carriers")
public class CarrierController {

    private final CarrierService carrierService;

    @Autowired
    public CarrierController(CarrierService carrierService) {
        this.carrierService = carrierService;
    }

    @GetMapping
    public ResponseEntity<Page<CarrierDTO>> findAll(Pageable pageable) {
        Page<CarrierDTO> carriers = carrierService.all(pageable);
        return ResponseEntity.ok(carriers);
    }

}
