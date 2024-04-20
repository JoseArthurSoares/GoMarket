package com.arthursoares.goMarket.exception.ProdutoException;

import com.arthursoares.goMarket.exception.GoMarketException;

public class ProdutoNaoExisteException extends GoMarketException {
    public ProdutoNaoExisteException() {
        super("O produto consultado nao existe");
    }
}
