package br.com.techchalleng4.mslogistica.controller;

import br.com.techchalleng4.mslogistica.dto.TrackingDTO;
import br.com.techchalleng4.mslogistica.service.TrackingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/trackings")
public class TrackingController {

    private final TrackingService service;

    @Autowired
    public TrackingController(TrackingService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<Page<TrackingDTO>> findAll(Pageable pageable) {
        Page<TrackingDTO> trackings = service.getAll(pageable);
        return ResponseEntity.ok(trackings);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TrackingDTO> findById(@PathVariable("id") String id) {
        TrackingDTO tracking = service.getById(id);
        return ResponseEntity.ok(tracking);
    }
}
