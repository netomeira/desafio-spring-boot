package com.cadastro.desafio.cidade;

import javax.validation.constraints.NotBlank;

public class CidadeDTO {
    @NotBlank(message = "Por favor preencha o campo 'nome'")
    private String nome;

    @NotBlank(message = "Por favor preencha o campo 'estado'")
    private String estado;

    public CidadeDTO(){}

    public CidadeDTO(String nome, String estado){
        this.nome = nome;
        this.estado = estado;
    }
    
    /**
     * @return String return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return String return the estado
     */
    public String getEstado() {
        return estado;
    }

    /**
     * @param estado the estado to set
     */
    public void setEstado(String estado) {
        this.estado = estado;
    }

}