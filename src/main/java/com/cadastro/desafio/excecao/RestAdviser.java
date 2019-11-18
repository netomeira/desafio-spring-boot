package com.cadastro.desafio.excecao;

import java.util.Arrays;
import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice
@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public class RestAdviser {
	
	@ExceptionHandler(NaoEncontradoException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public ErroResponse handleException(NaoEncontradoException ex) {
		return new ErroResponse(new Date(), 
					HttpStatus.NOT_FOUND.value(), 
					HttpStatus.NOT_FOUND.getReasonPhrase(), 
					Arrays.asList(ex.getMessage()));
	}

	@ExceptionHandler(Exception.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ErroResponse handleException(Exception ex) {
		return new ErroResponse(new Date(), 
					HttpStatus.BAD_REQUEST.value(), 
					HttpStatus.BAD_REQUEST.getReasonPhrase(), 
					Arrays.asList(ex.getMessage()));
	}
}
