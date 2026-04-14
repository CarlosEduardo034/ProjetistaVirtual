package com.fotovoltaico.backend.dto;

import lombok.Data;

@Data
public class ClienteDTO {
    private String nome;
    private String cpfCnpj;
    private String rg;
    private String dataExpedicao;
    private String endereco;
    private String telefoneCelular;
    private String telefoneFixo;
    private String cep;
    private String municipio;
    private String uf;
    private String email;
}