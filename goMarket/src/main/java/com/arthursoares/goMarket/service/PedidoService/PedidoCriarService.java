package com.arthursoares.goMarket.service.PedidoService;

import com.arthursoares.goMarket.dto.PedidoDTO.PedidoPostRequestDTO;
import com.arthursoares.goMarket.model.Pedido;

@FunctionalInterface
public interface PedidoCriarService {
    Pedido criar(Long clienteId, PedidoPostRequestDTO pedidoPostRequestDTO);
}
