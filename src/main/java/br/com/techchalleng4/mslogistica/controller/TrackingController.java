package br.com.techchalleng4.mslogistica.controller;

import br.com.techchalleng4.mslogistica.dto.ShippingDTO;
import br.com.techchalleng4.mslogistica.dto.TrackingDTO;
import br.com.techchalleng4.mslogistica.service.ShippingService;
import br.com.techchalleng4.mslogistica.service.TrackingService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/trackings")
@RequiredArgsConstructor
public class TrackingController {

    @Autowired
    private final TrackingService service;

    @GetMapping
    public ResponseEntity<Page<TrackingDTO>> findAll(Pageable pageable) {
        Page<TrackingDTO> shippings = service.getAll(pageable);
        return ResponseEntity.ok(shippings);
    }
}
