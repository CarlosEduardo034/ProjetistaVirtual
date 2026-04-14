package com.fotovoltaico.backend.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
@Entity
public class Modulo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer potencia;
    private Integer quantidade;
    private Double area;
    private String fabricante;
    private String modelo;

    @ManyToOne
    @JoinColumn(name = "projeto_id")
    private Projeto projeto;
}