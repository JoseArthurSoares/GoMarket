package com.arthursoares.goMarket.exception;

public class GoMarketException extends RuntimeException{
    public GoMarketException(){
        super("Erro imprevisto na aplicação");
    }

    public GoMarketException(String error){
        super(error);
    }
}
