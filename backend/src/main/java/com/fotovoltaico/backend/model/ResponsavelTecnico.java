package com.fotovoltaico.backend.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class ResponsavelTecnico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

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