package com.fotovoltaico.backend.dto;

import lombok.Data;

@Data
public class UnidadeConsumidoraDTO {
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