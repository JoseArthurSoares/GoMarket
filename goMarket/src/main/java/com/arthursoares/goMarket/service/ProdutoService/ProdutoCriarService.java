package com.arthursoares.goMarket.service.ProdutoService;


import com.arthursoares.goMarket.dto.ProdutoDTO.ProdutoPostPutRequestDTO;
import com.arthursoares.goMarket.model.Produto;

@FunctionalInterface
public interface ProdutoCriarService {
    Produto criar(ProdutoPostPutRequestDTO produtoPostPutRequestDTO);
}
