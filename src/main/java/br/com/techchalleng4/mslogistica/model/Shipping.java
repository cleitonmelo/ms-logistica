package br.com.techchalleng4.mslogistica.model;

import br.com.techchalleng4.mslogistica.enums.ShippingStatus;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.UUID;

@Entity
@Getter
@Builder
@Table( name = "tb_shippings")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Shipping implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String orderCode;

    private String recipient;

    private ShippingStatus status;

    private String zipCode;

}
