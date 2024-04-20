package com.arthursoares.goMarket.controller;

import com.arthursoares.goMarket.dto.ClienteDTO.ClientePostPutRequestDTO;
import com.arthursoares.goMarket.model.Cliente;
import com.arthursoares.goMarket.service.ClienteService.ClienteCriarService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public class ClienteRestController {
    ClienteCriarService clienteCriarService;

    public ClienteRestController(ClienteCriarService clienteCriarService) {
        this.clienteCriarService = clienteCriarService;
    }

    @PostMapping()
    public ResponseEntity<Cliente> criarCliente(
            @RequestBody @Valid ClientePostPutRequestDTO clientePostPutRequestDTO) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(this.clienteCriarService.criar(clientePostPutRequestDTO));


    }

}
