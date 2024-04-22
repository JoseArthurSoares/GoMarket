package com.arthursoares.goMarket.service.PedidoService;

import com.arthursoares.goMarket.dto.PedidoDTO.PedidoPostRequestDTO;
import com.arthursoares.goMarket.exception.ClienteException.ClienteNaoExisteException;
import com.arthursoares.goMarket.exception.ProdutoException.ProdutoNaoExisteException;
import com.arthursoares.goMarket.model.Pedido;
import com.arthursoares.goMarket.model.Produto;
import com.arthursoares.goMarket.repository.ClienteRepository;
import com.arthursoares.goMarket.repository.PedidoRepository;
import com.arthursoares.goMarket.repository.ProdutoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class PedidoCriarPadraoService implements PedidoCriarService{

    PedidoRepository pedidoRepository;
    ClienteRepository clienteRepository;
    ProdutoRepository produtoRepository;
    ModelMapper modelMapper;

    public PedidoCriarPadraoService(PedidoRepository pedidoRepository) {
        this.pedidoRepository = pedidoRepository;
        this.modelMapper = new ModelMapper();
    }

    @Override
    public Pedido criar(Long clienteId, PedidoPostRequestDTO pedidoPostRequestDTO) {
        clienteRepository.findById(clienteId).orElseThrow(ClienteNaoExisteException::new);
        Pedido pedido = modelMapper.map(pedidoPostRequestDTO, Pedido.class);
        pedido.setClienteId(clienteId);
        pedido.setPreco(calculaPrecoTotal(pedido));
        return pedidoRepository.save(pedido);
    }

    private Double calculaPrecoTotal(Pedido pedido) {
        Double precoTotal = 0.0;
        for(Produto produto : pedido.getProdutos()) {
            this.produtoRepository.findById(produto.getId()).orElseThrow(ProdutoNaoExisteException::new);
            precoTotal += produto.getPreco();
        }
        return precoTotal;
    }
}
