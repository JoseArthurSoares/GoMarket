package com.arthursoares.goMarket.controller;

import com.arthursoares.goMarket.dto.PedidoDTO.PedidoPostRequestDTO;
import com.arthursoares.goMarket.service.PedidoService.PedidoCriarService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pedidos")
public class PedidoRestController {
    PedidoCriarService pedidoCriarService;

    public PedidoRestController(PedidoCriarService pedidoCriarService) {
        this.pedidoCriarService = pedidoCriarService;
    }

    @PostMapping()
    public ResponseEntity<?> criarPedido(
            @RequestParam Long clienteId,
            @RequestBody @Valid PedidoPostRequestDTO pedidoPostRequestDTO) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(this.pedidoCriarService.criar(clienteId, pedidoPostRequestDTO));
    }
}
