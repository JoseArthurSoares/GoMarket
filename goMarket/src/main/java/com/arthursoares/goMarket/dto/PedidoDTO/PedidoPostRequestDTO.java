package com.arthursoares.goMarket.dto.PedidoDTO;

import com.arthursoares.goMarket.model.Produto;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PedidoPostRequestDTO {
    @JsonProperty("pedidos")
    @ManyToOne
    @NotEmpty(message = "Pedido deve conter pelo menos um produto")
    private List<Produto> produtos = new ArrayList<>();
}
