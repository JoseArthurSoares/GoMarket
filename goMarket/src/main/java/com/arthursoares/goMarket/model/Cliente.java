package com.arthursoares.goMarket.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "clientes")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "clientes_SEQ")
    @SequenceGenerator(name = "clientes_SEQ", sequenceName = "clientes_SEQ", allocationSize = 1)
    private Long id;

    @JsonProperty("nome")
    @Column(nullable = false)
    private String nome;

    @JsonProperty("endereco")
    @Column(nullable = false)
    private String endereco;

    @JsonProperty("email")
    @Column(nullable = false)
    private String email;

    @JsonProperty("senha")
    @Column(nullable = false)
    private String senha;
}
