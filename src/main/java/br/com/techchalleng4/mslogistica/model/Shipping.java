package br.com.techchalleng4.mslogistica.model;

import br.com.techchalleng4.mslogistica.enums.ShippingStatus;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;

@Entity
@Getter
@Builder
@Table( name = "shippings")
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

    @OneToOne(mappedBy = "shipping", cascade = CascadeType.ALL, orphanRemoval = true)
    private Address shippingAddress;

    @OneToMany(mappedBy = "shipping", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Product> products;

}
