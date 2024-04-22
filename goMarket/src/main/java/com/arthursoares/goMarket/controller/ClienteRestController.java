package com.arthursoares.goMarket.controller;

import com.arthursoares.goMarket.dto.ClienteDTO.ClientePostRequestDTO;
import com.arthursoares.goMarket.dto.ClienteDTO.ClientePutRequest;
import com.arthursoares.goMarket.dto.ClienteDTO.ClienteResponseDTO;
import com.arthursoares.goMarket.model.Cliente;
import com.arthursoares.goMarket.service.ClienteService.*;
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
    ClienteAlterarService clienteAlterarService;
    ClienteBuscarTodosService clienteBuscarTodosService;

    public ClienteRestController(ClienteCriarService clienteCriarService, ClienteDeletarService clienteDeletarService, ClienteBuscarService clienteBuscarService, ClienteAlterarService clienteAlterarService, ClienteBuscarTodosService clienteBuscarTodosService){
        this.clienteCriarService = clienteCriarService;
        this.clienteDeletarService = clienteDeletarService;
        this.clienteBuscarService = clienteBuscarService;
        this.clienteAlterarService = clienteAlterarService;
        this.clienteBuscarTodosService = clienteBuscarTodosService;
    }

    @PostMapping()
    public ResponseEntity<Cliente> criarCliente(
            @RequestBody @Valid ClientePostRequestDTO clientePostRequestDTO) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(this.clienteCriarService.criar(clientePostRequestDTO));


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

    @GetMapping()
    public ResponseEntity<?> buscarTodosClientes() {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(this.clienteBuscarTodosService.buscarTodos());
    }

    @PutMapping("{clienteId}")
    public ResponseEntity<?> alterarCliente(
            @PathVariable Long clienteId,
            @RequestBody @Valid ClientePutRequest clientePutRequestDTO
    ) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(this.clienteAlterarService.alterar(clienteId, clientePutRequestDTO));
    }

}
