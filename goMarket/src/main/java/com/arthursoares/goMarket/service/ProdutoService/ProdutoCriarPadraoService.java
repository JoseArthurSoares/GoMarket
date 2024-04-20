package com.arthursoares.goMarket.service.ProdutoService;

import com.arthursoares.goMarket.dto.ProdutoDTO.ProdutoPostPutRequestDTO;
import com.arthursoares.goMarket.model.Produto;
import com.arthursoares.goMarket.repository.ProdutoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class ProdutoCriarPadraoService implements ProdutoCriarService{

    ProdutoRepository produtoRepository;
    ModelMapper modelMapper;

    public ProdutoCriarPadraoService(ProdutoRepository produtoRepository){
        this.produtoRepository = produtoRepository;
        this.modelMapper = new ModelMapper();
    }

    @Override
    public Produto criar(ProdutoPostPutRequestDTO produtoPostPutRequestDTO) {
        Produto produto = this.modelMapper.map(produtoPostPutRequestDTO, Produto.class);
        return this.produtoRepository.save(produto);
    }
}
