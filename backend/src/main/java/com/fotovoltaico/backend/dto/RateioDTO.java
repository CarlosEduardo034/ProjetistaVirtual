package com.fotovoltaico.backend.dto;

import lombok.Data;

@Data
public class RateioDTO {
    private Double percentual;
    private String contaContrato;
    private String classe;
    private String endereco;
}