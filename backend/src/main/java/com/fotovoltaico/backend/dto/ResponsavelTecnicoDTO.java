package com.fotovoltaico.backend.dto;

import lombok.Data;

@Data
public class ResponsavelTecnicoDTO {
    private String nome;
    private String titulo;
    private String registro;
    private String ufRegistro;
    private String email;
    private String telefoneFixo;
    private String telefoneCelular;
    private String endereco;
    private String bairro;
    private String municipio;
    private String uf;
    private String cep;
}