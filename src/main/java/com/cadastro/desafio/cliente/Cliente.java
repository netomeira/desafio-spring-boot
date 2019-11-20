package com.cadastro.desafio.cliente;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import com.cadastro.desafio.cidade.Cidade;
import com.cadastro.desafio.utils.CalcularIdadeUtils;
import com.fasterxml.jackson.annotation.JsonProperty;

@Table(name = "cliente")
@Entity
public class Cliente {
    @Column(name = "id")
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "nome")
    private String nome;
    
    @Column(name = "genero")
    @Enumerated(EnumType.STRING)
    private Genero genero;
    
    @Column(name = "data_nascimento")
    @Temporal(TemporalType.DATE)
    private Date dataNascimento;
    
    @JoinColumn(name = "cidade_id")
    @ManyToOne
    private Cidade cidade;

    @Transient
    @JsonProperty
    private Integer idade;

    public Cliente() {}
    public Cliente(Long id, String nome, Genero genero, Date dataNascimento, Cidade cidade) {
        this.id = id;
        this.nome = nome;
        this.genero = genero;
        this.dataNascimento = dataNascimento;
        this.cidade = cidade;
    }

    /**
     * @return Long return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
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
     * @return Genero return the genero
     */
    public Genero getGenero() {
        return genero;
    }

    /**
     * @param genero the genero to set
     */
    public void setGenero(Genero genero) {
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

    public Integer getIdade() {
        return CalcularIdadeUtils.calcular(this.dataNascimento);
    }

    /**
     * @return Cidade return the cidade
     */
    public Cidade getCidade() {
        return cidade;
    }

    /**
     * @param cidade the cidade to set
     */
    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }

}