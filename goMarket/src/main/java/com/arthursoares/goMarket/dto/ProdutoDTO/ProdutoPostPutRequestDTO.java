package com.arthursoares.goMarket.dto.ProdutoDTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProdutoPostPutRequestDTO {


    @JsonProperty("nome")
    @NotBlank(message = "Nome obrigatorio")
    private String nome;

    @JsonProperty("descricao")
    private String descricao;

    @JsonProperty("quantidadeDisponivel")
    @NotBlank(message = "Quantidade disponivel obrigatorio")
    private int quantidadeDisponivel;

    @JsonProperty("preco")
    @NotBlank(message = "Preco obrigatorio")
    private Double preco;
}
