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
@Table(name = "produtos")
public class Produto {

    @JsonProperty("id")
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @JsonProperty("nome")
    @Column(nullable = false)
    private Double nome;

    @JsonProperty("descricao")
    private Double descricao;

    @JsonProperty("quantidadeDisponivel")
    @Column(nullable = false)
    private Double quantidadeDisponivel;

    @JsonProperty("preco")
    @Column(nullable = false)
    private Double preco;
}
