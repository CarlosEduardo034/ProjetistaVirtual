package com.fotovoltaico.backend.model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDate;

@Data
@Entity
public class Solicitacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String tipoOrcamento;
    private String tipoSolicitacao;
    private String potenciaExistente;
    private Boolean possuiCargasEspeciais;
    private String detalhamentoCargas;
    private String ramoAtividade;
    private String fontePrimaria;
    private String especificacaoFonte;
    private String tipoGeracao;
    private String modalidadeCompensacao;
    private LocalDate dataInicioOperacao;
}