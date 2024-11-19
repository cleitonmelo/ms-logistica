package br.com.techchalleng4.mslogistica.service;

import br.com.techchalleng4.mslogistica.dto.TrackingDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface TrackingService {

    Page<TrackingDTO> getAll(Pageable pageable);

}
