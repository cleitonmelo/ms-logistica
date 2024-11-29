package br.com.techchalleng4.mslogistica.controller;

import br.com.techchalleng4.mslogistica.service.TrackingService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.data.domain.Pageable;

import java.util.UUID;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class TrackingControllerTest {

    @Mock
    TrackingService trackingService;

    TrackingController trackingController;

    AutoCloseable openMocks;

    @BeforeEach
    void setUp() {
        openMocks = MockitoAnnotations.openMocks(this);
        trackingController = new TrackingController(trackingService);
    }

    @AfterEach
    void tearDown() throws Exception {
        openMocks.close();
    }

    @Test
    void mustReturnTrackingList(){
        var presenter = trackingController.findAll(Pageable.unpaged());
        assertThat(presenter.getBody()).isNull();
    }

    @Test
    void mustTrackingById(){
        var presenter = trackingController.findById(UUID.randomUUID().toString());
        assertThat(presenter.getBody()).isNull();
    }
}
