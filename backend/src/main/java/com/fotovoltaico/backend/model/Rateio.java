package com.fotovoltaico.backend.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Rateio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double percentual;
    private String contaContrato;
    private String classe;
    private String endereco;

    @ManyToOne
    @JoinColumn(name = "projeto_id")
    private Projeto projeto;
}