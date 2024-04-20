package com.arthursoares.goMarket.service.ProdutoService;

import com.arthursoares.goMarket.model.Produto;

@FunctionalInterface
public interface ProdutoDeletarService {
    void deletarProduto(Long id);
}

