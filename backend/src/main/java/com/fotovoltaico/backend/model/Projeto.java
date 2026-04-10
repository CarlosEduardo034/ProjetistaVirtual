package com.fotovoltaico.backend.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import lombok.Data;

@Entity
@Data

public class Projeto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nomeCliente;
    private LocalDateTime dataCriacao = LocalDateTime.now();

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "modulo_id")
    private Modulo modulo;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "inversor_id")
    private Inversor inversor;
}