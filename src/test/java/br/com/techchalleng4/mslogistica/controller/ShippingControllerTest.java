package br.com.techchalleng4.mslogistica.controller;

import br.com.techchalleng4.mslogistica.base.BaseTest;
import br.com.techchalleng4.mslogistica.dto.AddressDTO;
import br.com.techchalleng4.mslogistica.dto.ProductDTO;
import br.com.techchalleng4.mslogistica.dto.ShippingDTO;
import br.com.techchalleng4.mslogistica.enums.ShippingStatus;
import br.com.techchalleng4.mslogistica.service.ShippingService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.data.domain.Pageable;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class ShippingControllerTest extends BaseTest {

    @Mock
    ShippingService shippingService;

    ShippingController shippingController;

    AutoCloseable openMocks;

    @BeforeEach
    void setUp() {
        openMocks = MockitoAnnotations.openMocks(this);
        shippingController = new ShippingController(shippingService);
    }

    @AfterEach
    void tearDown() throws Exception {
        openMocks.close();
    }

    @Test
    void mustReturnShipping(){
        var presenter = shippingController.insert(getShippingDtoForInsert());
        assertThat(presenter.getBody()).isNull();
    }

    @Test
    void mustReturnShippingList(){
        var presenter = shippingController.findAll(Pageable.unpaged());
        assertThat(presenter.getBody()).isNull();
    }

    @Test
    void mustFinishShipping(){
        var presenter = shippingController.finished(UUID.randomUUID().toString());
        assertThat(presenter.getBody()).isNull();
    }

    @Test
    void mustProcessShipping(){
        var presenter = shippingController.process();
        assertThat(presenter.getBody()).isNull();
    }

    @Test
    void mustShippingById(){
        var presenter = shippingController.get(UUID.randomUUID().toString());
        assertThat(presenter.getBody()).isNull();
    }

}
