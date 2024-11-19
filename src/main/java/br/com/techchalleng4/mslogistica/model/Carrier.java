package br.com.techchalleng4.mslogistica.model;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.UUID;

@Entity
@Getter
@Builder
@Table ( name = "carriers")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Carrier implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long code;

    private String name;

    private Integer zipCodeStart;

    private Integer zipCodeEnd;
}
