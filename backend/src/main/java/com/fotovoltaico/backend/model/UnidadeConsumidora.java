package com.fotovoltaico.backend.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class UnidadeConsumidora {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String contaContrato;
    private String classe;
    private String tipoLigacao;
    private String tensao;
    private Double cargaDeclarada;
    private String disjuntor;
    private String tipoRamal;
    private String identificacaoPoste;
    private String coordenadaX;
    private String coordenadaY;
    private Boolean possuiRateio;
    private String formaAlocacao;
    private String destinoExcedente;
}