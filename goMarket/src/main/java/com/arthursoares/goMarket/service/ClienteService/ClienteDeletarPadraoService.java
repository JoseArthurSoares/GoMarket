package com.arthursoares.goMarket.service.ClienteService;

import com.arthursoares.goMarket.exception.ClienteException.ClienteNaoExisteException;
import com.arthursoares.goMarket.model.Cliente;
import com.arthursoares.goMarket.repository.ClienteRepository;
import org.springframework.stereotype.Service;

@Service
public class ClienteDeletarPadraoService implements ClienteDeletarService {
    ClienteRepository clienteRepository;

    @Override
    public void remover(Long id) {
        Cliente cliente = this.clienteRepository.findById(id)
                .orElseThrow(ClienteNaoExisteException::new);
        this.clienteRepository.delete(cliente);
    }
}
