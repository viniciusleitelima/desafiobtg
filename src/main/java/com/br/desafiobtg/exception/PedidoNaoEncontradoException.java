package com.br.desafiobtg.exception;

public class PedidoNaoEncontradoException extends RuntimeException{
    public PedidoNaoEncontradoException(String message){
        super(message);
    }
}
