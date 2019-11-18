package com.cadastro.desafio.excecao;

import org.springframework.http.HttpStatus;

public class NaoEncontradoException extends RuntimeException{

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    
    public HttpStatus status = HttpStatus.NOT_FOUND;
    public String mensagem = "Entidade não encontrada";

    public NaoEncontradoException(){}

    public NaoEncontradoException(String mensagem){
        this.mensagem = mensagem;
    }
}