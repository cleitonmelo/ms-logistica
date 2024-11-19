package br.com.techchalleng4.mslogistica.model;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.UUID;

@Entity
@Getter
@Setter
@Builder
@Table(name = "trackings")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Tracking  implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne
    private Carrier carrier;

    @ManyToOne
    private Shipping shipping;

    private Double latitude;

    private Double longitude;
}
