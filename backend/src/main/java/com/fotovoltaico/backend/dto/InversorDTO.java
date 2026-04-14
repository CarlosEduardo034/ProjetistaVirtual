package com.fotovoltaico.backend.dto;

import lombok.Data;

@Data
public class InversorDTO {
    private String fabricante;
    private String modelo;
    private Double potenciaNominal;
    private String tensaoOperacao;
    private Double correnteNominal;
    private String fatorPotencia;
    private String rendimento;
    private String dht;
}