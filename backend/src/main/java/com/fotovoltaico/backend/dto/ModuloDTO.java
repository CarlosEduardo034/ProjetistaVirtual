package com.fotovoltaico.backend.dto;

import lombok.Data;

@Data
public class ModuloDTO {
    private Integer potencia;
    private Integer quantidade;
    private Double area;
    private String fabricante;
    private String modelo;
}