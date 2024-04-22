package com.arthursoares.goMarket.service.ClienteService;

import com.arthursoares.goMarket.dto.ClienteDTO.ClienteResponseDTO;
import com.arthursoares.goMarket.exception.ClienteException.ClienteNaoExisteException;
import com.arthursoares.goMarket.model.Cliente;
import com.arthursoares.goMarket.repository.ClienteRepository;
import org.springframework.stereotype.Service;

@Service
public class ClienteBuscarPadraoService implements ClienteBuscarService{
    ClienteRepository clienteRepository;

    public ClienteBuscarPadraoService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }


    @Override
    public ClienteResponseDTO buscar(Long clienteId) {
        Cliente cliente = this.clienteRepository.findById(clienteId)
                .orElseThrow(ClienteNaoExisteException::new);
        return ClienteResponseDTO.builder()
                .id(cliente.getId())
                .nome(cliente.getNome())
                .endereco(cliente.getEndereco())
                .email(cliente.getEmail())
                .build();
    }
}
