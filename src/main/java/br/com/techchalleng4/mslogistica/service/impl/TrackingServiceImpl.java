package br.com.techchalleng4.mslogistica.service.impl;

import br.com.techchalleng4.mslogistica.dto.TrackingDTO;
import br.com.techchalleng4.mslogistica.dto.mappers.TrackingMapper;
import br.com.techchalleng4.mslogistica.model.Tracking;
import br.com.techchalleng4.mslogistica.repository.TrackingRepository;
import br.com.techchalleng4.mslogistica.service.TrackingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class TrackingServiceImpl implements TrackingService {

    @Autowired
    private TrackingRepository trackingRepository;

    @Override
    public Page<TrackingDTO> getAll(Pageable pageable) {
        Page<Tracking> trackings = trackingRepository.findAll(pageable);
        return trackings.map(TrackingMapper::toDTO);
    }

    @Override
    public TrackingDTO getById(String id) {
        Tracking tracking = trackingRepository.findById(UUID.fromString(id)).orElse(null);
        if ( tracking != null ) {
            return TrackingMapper.toDTO(tracking);
        }
        return null;
    }
}
