package com.fotovoltaico.backend.model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDate;

@Data
@Entity
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String cpfCnpj;
    private String rg;
    private LocalDate dataExpedicao;
    private String endereco;
    private String telefoneCelular;
    private String telefoneFixo;
    private String cep;
    private String municipio;
    private String uf;
    private String email;
}