package com.cadastro.desafio.cliente;

public class ClienteTO {

    private String nome;
    private String genero;
    private String dataNascimento;
    private Long cidadeId;

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
     * @return String return the dataNascimento
     */
    public String getDataNascimento() {
        return dataNascimento;
    }

    /**
     * @param dataNascimento the dataNascimento to set
     */
    public void setDataNascimento(String dataNascimento) {
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