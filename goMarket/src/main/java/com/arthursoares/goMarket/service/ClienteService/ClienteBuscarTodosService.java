package com.arthursoares.goMarket.service.ClienteService;

import com.arthursoares.goMarket.dto.ClienteDTO.ClienteResponseDTO;
import com.arthursoares.goMarket.model.Cliente;

import java.util.List;

@FunctionalInterface
public interface ClienteBuscarTodosService {

     List<Cliente> buscarTodos();
}
