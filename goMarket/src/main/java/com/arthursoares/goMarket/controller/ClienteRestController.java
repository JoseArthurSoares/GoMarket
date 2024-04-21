package com.arthursoares.goMarket.controller;

import com.arthursoares.goMarket.dto.ClienteDTO.ClientePostPutRequestDTO;
import com.arthursoares.goMarket.dto.ClienteDTO.ClienteResponseDTO;
import com.arthursoares.goMarket.model.Cliente;
import com.arthursoares.goMarket.service.ClienteService.ClienteBuscarService;
import com.arthursoares.goMarket.service.ClienteService.ClienteCriarService;
import com.arthursoares.goMarket.service.ClienteService.ClienteDeletarService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/clientes")
public class ClienteRestController {
    ClienteCriarService clienteCriarService;
    ClienteDeletarService clienteDeletarService;
    ClienteBuscarService clienteBuscarService;

    public ClienteRestController(ClienteCriarService clienteCriarService, ClienteDeletarService clienteDeletarService, ClienteBuscarService clienteBuscarService) {
        this.clienteCriarService = clienteCriarService;
        this.clienteDeletarService = clienteDeletarService;
        this.clienteBuscarService = clienteBuscarService;
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

    @GetMapping("{clienteId}")
    public ResponseEntity<ClienteResponseDTO> buscarCliente(
            @PathVariable Long clienteId
    ) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(this.clienteBuscarService.buscar(clienteId));
    }

}
