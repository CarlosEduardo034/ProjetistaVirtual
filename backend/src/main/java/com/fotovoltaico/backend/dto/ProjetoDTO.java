package com.fotovoltaico.backend.dto;

import lombok.Data;
import java.util.List;

@Data
public class ProjetoDTO {

    private ClienteDTO cliente;
    private SolicitacaoDTO solicitacao;
    private UnidadeConsumidoraDTO uc;
    private ResponsavelTecnicoDTO responsavel;

    private List<ModuloDTO> modulos;
    private List<InversorDTO> inversores;
    private List<RateioDTO> rateios;
}