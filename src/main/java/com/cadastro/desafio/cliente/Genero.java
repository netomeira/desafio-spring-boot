package com.cadastro.desafio.cliente;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum Genero {
    
    @JsonProperty("F") F,
	@JsonProperty("M") M;

    public static Genero get(String genero) {
		for (Genero g : Genero.values()) {
			if (g.name().equals(genero)) {
				return g;
			}
		}
		return null;
	}
}