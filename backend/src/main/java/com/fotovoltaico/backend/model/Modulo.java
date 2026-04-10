    package com.fotovoltaico.backend.model;

    import com.fasterxml.jackson.annotation.JsonIgnore;

    import jakarta.persistence.Entity;
    import jakarta.persistence.GeneratedValue;
    import jakarta.persistence.GenerationType;
    import jakarta.persistence.Id;
    import jakarta.persistence.OneToOne;
    import lombok.Data;

    @Data
    @Entity
    public class Modulo {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        private Integer potencia;
        private Integer quantidade;
        private Double area;
        private String fabricante;
        private String modelo;

        @OneToOne(mappedBy = "modulo")
        @JsonIgnore
        private Projeto projeto;

        public Projeto getProjeto() {
            return projeto;
        }

        public void setProjeto(Projeto projeto) {
            this.projeto = projeto;
        }
    }