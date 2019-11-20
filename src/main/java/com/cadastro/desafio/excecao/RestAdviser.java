package com.cadastro.desafio.excecao;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice
@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public class RestAdviser {
	
	Logger LOG = LoggerFactory.getLogger(RestAdviser.class);

	@ExceptionHandler(NaoEncontradoException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public ErroResponse handleException(NaoEncontradoException ex) {
		return new ErroResponse(new Date(), 
					HttpStatus.NOT_FOUND.value(), 
					HttpStatus.NOT_FOUND.getReasonPhrase(), 
					Arrays.asList(ex.getMessage()));
	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ErroResponse handleException(MethodArgumentNotValidException ex) {
		List<String> errors = ex.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(x -> x.getDefaultMessage())
				.collect(Collectors.toList());
				
		return new ErroResponse(new Date(), 
					HttpStatus.BAD_REQUEST.value(), 
					HttpStatus.BAD_REQUEST.getReasonPhrase(), 
					errors);
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
