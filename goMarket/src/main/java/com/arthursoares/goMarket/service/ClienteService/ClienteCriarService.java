package com.arthursoares.goMarket.service.ClienteService;

import com.arthursoares.goMarket.dto.ClienteDTO.ClientePostPutRequestDTO;
import com.arthursoares.goMarket.model.Cliente;

@FunctionalInterface
public interface ClienteCriarService {
    Cliente criar(ClientePostPutRequestDTO clientePostPutRequestDTO);
}
