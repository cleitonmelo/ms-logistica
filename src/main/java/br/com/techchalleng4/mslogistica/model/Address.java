package br.com.techchalleng4.mslogistica.model;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serial;
import java.io.Serializable;
import java.util.UUID;

@Entity
@Getter
@Builder
@Table( name = "addresses")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Address implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String street;

    private Integer number;

    private String complement;

    private String city;

    private String neighborhood;

    private String state;

    private Integer zipCode;

    private String country;

    private String phone;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "shippingId")
    private Shipping shipping;
}
