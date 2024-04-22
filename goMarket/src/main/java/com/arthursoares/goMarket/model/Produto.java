package com.arthursoares.goMarket.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "produtos")
public class Produto {

    @JsonProperty("id")
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "produtos_SEQ")
    @SequenceGenerator(name = "produtos_SEQ", sequenceName = "produtos_SEQ", allocationSize = 1)
    private Long id;

    @JsonProperty("nome")
    @Column(nullable = false)
    private String nome;

    @JsonProperty("descricao")
    private String descricao;

    @JsonProperty("quantidadeDisponivel")
    @Column(nullable = false)
    private int quantidadeDisponivel;

    @JsonProperty("preco")
    @Column(nullable = false)
    private Double preco;

    @ManyToMany(mappedBy = "produtos")
    private List<Pedido> pedidos = new ArrayList<>();

}
