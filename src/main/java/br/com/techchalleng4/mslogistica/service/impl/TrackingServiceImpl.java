package br.com.techchalleng4.mslogistica.service.impl;

import br.com.techchalleng4.mslogistica.dto.ShippingDTO;
import br.com.techchalleng4.mslogistica.dto.TrackingDTO;
import br.com.techchalleng4.mslogistica.dto.mappers.TrackingMapper;
import br.com.techchalleng4.mslogistica.model.Tracking;
import br.com.techchalleng4.mslogistica.repository.TrackingRepository;
import br.com.techchalleng4.mslogistica.service.TrackingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class TrackingServiceImpl implements TrackingService {

    @Autowired
    private TrackingRepository trackingRepository;

    @Override
    public Page<TrackingDTO> getAll(Pageable pageable) {
        Page<Tracking> trackings = trackingRepository.findAll(pageable);
        return trackings.map(TrackingMapper::toDTO);
    }

    public static void createTracking(ShippingDTO shippingDTO) {
        System.out.println(shippingDTO);
    }
}
