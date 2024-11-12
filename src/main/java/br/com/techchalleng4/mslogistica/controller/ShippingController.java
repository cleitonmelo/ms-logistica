package br.com.techchalleng4.mslogistica.controller;

import br.com.techchalleng4.mslogistica.dto.ShippingDTO;
import br.com.techchalleng4.mslogistica.service.ShippingService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/shippings")
@RequiredArgsConstructor
public class ShippingController {

    @Autowired
    private final ShippingService shippingService;

    @GetMapping
    public ResponseEntity<Page<ShippingDTO>> findAll(Pageable pageable) {
        Page<ShippingDTO> shippings = shippingService.get(pageable);
        return ResponseEntity.ok(shippings);
    }

    @PostMapping
    public ResponseEntity<ShippingDTO> insert(@RequestBody ShippingDTO shippingDTO) {
        ShippingDTO shipping = shippingService.create(shippingDTO);
        return ResponseEntity.ok(shipping);
    }

}
