package com.arthursoares.goMarket.service.ProdutoService;

import com.arthursoares.goMarket.exception.ProdutoException.ProdutoNaoExisteException;
import com.arthursoares.goMarket.model.Produto;
import com.arthursoares.goMarket.repository.ProdutoRepository;

public class ProdutoDeletarPadraoService implements ProdutoDeletarService {
    ProdutoRepository produtoRepository;


    @Override
    public void deletarProduto(Long id) {
        Produto produto = this.produtoRepository.findById(id)
                .orElseThrow(ProdutoNaoExisteException::new);
        this.produtoRepository.delete(produto);
    }
}
