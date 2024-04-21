package com.arthursoares.goMarket.controller;

import com.arthursoares.goMarket.dto.ClienteDTO.ClientePostPutRequestDTO;
import com.arthursoares.goMarket.model.Cliente;
import com.arthursoares.goMarket.service.ClienteService.ClienteCriarService;
import com.arthursoares.goMarket.service.ClienteService.ClienteDeletarService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public class ClienteRestController {
    ClienteCriarService clienteCriarService;
    ClienteDeletarService clienteDeletarService;

    public ClienteRestController(ClienteCriarService clienteCriarService, ClienteDeletarService clienteDeletarService) {
        this.clienteCriarService = clienteCriarService;
        this.clienteDeletarService = clienteDeletarService;
    }

    @PostMapping()
    public ResponseEntity<Cliente> criarCliente(
            @RequestBody @Valid ClientePostPutRequestDTO clientePostPutRequestDTO) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(this.clienteCriarService.criar(clientePostPutRequestDTO));


    }

    @DeleteMapping("{clienteId}")
    public ResponseEntity<?> deletarCliente(
            @PathVariable Long clienteId
    ) {
        this.clienteDeletarService.remover(clienteId);
        return ResponseEntity
                .status(HttpStatus.NO_CONTENT)
                .body("");
    }

}
