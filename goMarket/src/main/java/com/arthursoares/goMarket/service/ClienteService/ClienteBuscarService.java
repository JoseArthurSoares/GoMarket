package com.arthursoares.goMarket.service.ClienteService;

import com.arthursoares.goMarket.dto.ClienteDTO.ClienteResponseDTO;

@FunctionalInterface
public interface ClienteBuscarService {
    ClienteResponseDTO buscar(Long clienteId);
}
