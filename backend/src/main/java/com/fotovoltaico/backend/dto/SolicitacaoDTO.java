package com.fotovoltaico.backend.dto;

import lombok.Data;

@Data
public class SolicitacaoDTO {
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
    private String dataInicioOperacao;
}