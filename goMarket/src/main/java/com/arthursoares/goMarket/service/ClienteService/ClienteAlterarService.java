package com.arthursoares.goMarket.service.ClienteService;

import com.arthursoares.goMarket.dto.ClienteDTO.ClientePutRequest;
import com.arthursoares.goMarket.dto.ClienteDTO.ClienteResponseDTO;

@FunctionalInterface
public interface ClienteAlterarService {
    ClienteResponseDTO alterar(Long clienteId, ClientePutRequest clientePutRequestDTO);
}
