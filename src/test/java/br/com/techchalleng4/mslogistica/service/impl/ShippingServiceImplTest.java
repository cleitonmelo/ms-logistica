package br.com.techchalleng4.mslogistica.service.impl;

import br.com.techchalleng4.mslogistica.model.Shipping;
import br.com.techchalleng4.mslogistica.repository.AddressRepository;
import br.com.techchalleng4.mslogistica.repository.ProductRepository;
import br.com.techchalleng4.mslogistica.repository.ShippingRepository;
import br.com.techchalleng4.mslogistica.service.ShippingService;
import br.com.techchalleng4.mslogistica.service.base.ShippingServiceBaseTest;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

@SpringBootTest
class ShippingServiceImplTest extends ShippingServiceBaseTest {

    private ShippingService shippingService;

    @Mock
    private ShippingRepository shippingRepository;

    @Mock
    private ProductRepository productRepository;

    @Mock
    private AddressRepository addressRepository;

    AutoCloseable openMocks;

    @BeforeEach
    void setUp() {
        openMocks = MockitoAnnotations.openMocks(this);
        shippingService = new ShippingServiceImpl(shippingRepository, productRepository, addressRepository);
    }

    @AfterEach
    void tearDown() throws Exception {
        openMocks.close();
    }

    @Test
    void mustAllowRecordingSending(){
        var shipping = createShippingDTO();

        when(shippingRepository.save(any(Shipping.class)))
                .thenAnswer(i -> i.getArguments()[0]);

        var shippingStorage = shippingService.create(createShippingDTO());

        assertThat(shippingStorage)
                .isInstanceOf(Shipping.class)
                .isNotNull();

        assertThat(shippingStorage.orderCode()).isNotNull();

        assertThat(shippingStorage.recipient()).isEqualTo(shipping.recipient());

    }

}
