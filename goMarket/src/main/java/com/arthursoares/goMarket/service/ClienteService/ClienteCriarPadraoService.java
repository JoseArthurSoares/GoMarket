package com.arthursoares.goMarket.service.ClienteService;

import com.arthursoares.goMarket.dto.ClienteDTO.ClientePostPutRequestDTO;
import com.arthursoares.goMarket.model.Cliente;
import com.arthursoares.goMarket.repository.ClienteRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class ClienteCriarPadraoService implements ClienteCriarService {
    ClienteRepository clienteRepository;
    ModelMapper modelMapper;

    public ClienteCriarPadraoService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
        this.modelMapper = new ModelMapper();
    }

    @Override
    public Cliente criar(ClientePostPutRequestDTO clientePostPutRequestDTO) {
        Cliente cliente = this.modelMapper.map(clientePostPutRequestDTO, Cliente.class);
        return this.clienteRepository.save(cliente);
    }
}
