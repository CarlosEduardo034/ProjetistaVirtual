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
public class Inversor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String fabricante;
    private String modelo;
    private Double potenciaNominal;
    private String tensaoOperacao;
    private Double correnteNominal;
    private String fatorPotencia;
    private String rendimento;
    private String dht;

    @ManyToOne
    @JoinColumn(name = "projeto_id")
    private Projeto projeto;
}