package com.arthursoares.goMarket.service.ClienteService;

import com.arthursoares.goMarket.dto.ClienteDTO.ClientePutRequest;
import com.arthursoares.goMarket.dto.ClienteDTO.ClienteResponseDTO;
import com.arthursoares.goMarket.exception.ClienteException.ClienteNaoExisteException;
import com.arthursoares.goMarket.model.Cliente;
import com.arthursoares.goMarket.repository.ClienteRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class ClienteAlterarPadraoService implements ClienteAlterarService{

    ClienteRepository clienteRepository;
    ModelMapper modelMapper;

    public ClienteAlterarPadraoService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
        this.modelMapper = new ModelMapper();
    }
    @Override
    public ClienteResponseDTO alterar(Long clienteId, ClientePutRequest clientePutRequestDTO) {
        this.clienteRepository.findById(clienteId).orElseThrow(ClienteNaoExisteException::new);
        Cliente clienteAlterado = this.modelMapper.map(clientePutRequestDTO,Cliente.class);
        clienteAlterado.setId(clienteId);
        this.clienteRepository.save(clienteAlterado);
        return ClienteResponseDTO.builder()
                .id(clienteAlterado.getId())
                .nome(clienteAlterado.getNome())
                .endereco(clienteAlterado.getEndereco())
                .email(clienteAlterado.getEmail())
                .build();
    }
}
