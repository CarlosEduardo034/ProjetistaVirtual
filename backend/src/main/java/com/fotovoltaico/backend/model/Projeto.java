package com.fotovoltaico.backend.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Projeto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nomeCliente;

    private LocalDateTime dataCriacao = LocalDateTime.now();

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "solicitacao_id")
    private Solicitacao solicitacao;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "uc_id")
    private UnidadeConsumidora uc;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "responsavel_id")
    private ResponsavelTecnico responsavel;

    @OneToMany(mappedBy = "projeto", cascade = CascadeType.ALL)
    private List<Modulo> modulos = new ArrayList<>();

    @OneToMany(mappedBy = "projeto", cascade = CascadeType.ALL)
    private List<Inversor> inversores = new ArrayList<>();

    @OneToMany(mappedBy = "projeto", cascade = CascadeType.ALL)
    private List<Rateio> rateios = new ArrayList<>();
}
