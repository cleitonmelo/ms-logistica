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
public class ShippingController {

    private final ShippingService shippingService;

    @Autowired
    public ShippingController(ShippingService shippingService) {
        this.shippingService = shippingService;
    }

    @GetMapping
    public ResponseEntity<Page<ShippingDTO>> findAll(Pageable pageable) {
        Page<ShippingDTO> shippings = shippingService.getAll(pageable);
        return ResponseEntity.ok(shippings);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ShippingDTO> get(@PathVariable String id) {
        ShippingDTO shippingDTO = shippingService.get(id);
        return ResponseEntity.ok(shippingDTO);
    }

    @PostMapping
    public ResponseEntity<ShippingDTO> insert(@RequestBody ShippingDTO shippingDTO) {
        ShippingDTO shipping = shippingService.create(shippingDTO);
        return ResponseEntity.ok(shipping);
    }

    @PutMapping("/finished/{id}")
    public ResponseEntity<ShippingDTO> finished(@PathVariable String id) {
        shippingService.finished(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/process")
    public ResponseEntity<ShippingDTO> process() {
        shippingService.process();
        return ResponseEntity.noContent().build();
    }

}
