package br.com.techchalleng4.mslogistica.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class ErrorResponseDTO {
    private String message;
    private List<String> errors;
}
