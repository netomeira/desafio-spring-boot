package com.cadastro.desafio.cliente;

import java.util.Date;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;

public class ClienteDTO {

    @NotBlank(message = "Por favor preencha o campo 'nome'")
    private String nome;

    @NotBlank(message = "Por favor preencha o campo 'genero'")
    private String genero;

    @NotNull(message = "Por favor preencha o campo 'dataNascimento'")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date dataNascimento;

    @NotNull(message = "Por favor preencha o campo 'cidadeId'")
    private Long cidadeId;

    public ClienteDTO(){}
    public ClienteDTO(String nome, String genero, Date dataNascimento, Long cidadeId) {
        this.nome = nome;
        this.genero = genero;
        this.dataNascimento = dataNascimento;
        this.cidadeId = cidadeId;
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
     * @return String return the genero
     */
    public String getGenero() {
        return genero;
    }

    /**
     * @param genero the genero to set
     */
    public void setGenero(String genero) {
        this.genero = genero;
    }

    /**
     * @return Date return the dataNascimento
     */
    public Date getDataNascimento() {
        return dataNascimento;
    }

    /**
     * @param dataNascimento the dataNascimento to set
     */
    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    /**
     * @return Long return the cidadeId
     */
    public Long getCidadeId() {
        return cidadeId;
    }

    /**
     * @param cidadeId the cidadeId to set
     */
    public void setCidadeId(Long cidadeId) {
        this.cidadeId = cidadeId;
    }

}