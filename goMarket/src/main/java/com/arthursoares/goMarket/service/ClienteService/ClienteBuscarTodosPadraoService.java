package com.arthursoares.goMarket.service.ClienteService;

import com.arthursoares.goMarket.model.Cliente;
import com.arthursoares.goMarket.repository.ClienteRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteBuscarTodosPadraoService implements ClienteBuscarTodosService{

    ClienteRepository clienteRepository;

    public ClienteBuscarTodosPadraoService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    @Override
    public List<Cliente> buscarTodos() {
        return clienteRepository.findAll();
    }
}
