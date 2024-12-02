package br.com.techchalleng4.mslogistica.model;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Entity
@Getter
@Builder
@Table ( name = "carriers")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Carrier implements Serializable {

    @Id
    private Integer code;

    private String name;

    private Integer zipCodeStart;

    private Integer zipCodeEnd;

    private Integer deliveryLimitDays;
}
