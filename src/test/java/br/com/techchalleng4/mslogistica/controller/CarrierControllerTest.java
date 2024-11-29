package br.com.techchalleng4.mslogistica.controller;

import br.com.techchalleng4.mslogistica.service.CarrierService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.data.domain.Pageable;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class CarrierControllerTest {

    @Mock
    CarrierService carrierService;

    CarrierController carrierController;

    AutoCloseable openMocks;

    @BeforeEach
    void setUp() {
        openMocks = MockitoAnnotations.openMocks(this);
        carrierController = new CarrierController(carrierService);
    }

    @AfterEach
    void tearDown() throws Exception {
        openMocks.close();
    }

    @Test
    void mustReturnCarrierList(){
        var presenter = carrierController.findAll(Pageable.unpaged());
        assertThat(presenter.getBody()).isNull();
    }
}
