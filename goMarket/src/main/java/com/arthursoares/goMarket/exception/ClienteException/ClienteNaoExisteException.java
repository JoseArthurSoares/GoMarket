package com.arthursoares.goMarket.exception.ClienteException;

import com.arthursoares.goMarket.exception.GoMarketException;

public class ClienteNaoExisteException extends GoMarketException {
    public ClienteNaoExisteException() {
        super("O cliente consultado nao existe");
    }
}
