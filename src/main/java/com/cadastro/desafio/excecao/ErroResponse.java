package com.cadastro.desafio.excecao;

import java.util.Date;
import java.util.List;

public class ErroResponse {
    private Date timestamp;
    private Integer status;
    private String erro;
    private List<String> mensagens;

    public ErroResponse() {
    }

    public ErroResponse(Date timestamp, Integer status, String erro, List<String> mensagens) {
        this.timestamp = timestamp;
        this.status = status;
        this.erro = erro;
        this.mensagens = mensagens;
    }

    /**
     * @return Date return the timestamp
     */
    public Date getTimestamp() {
        return timestamp;
    }

    /**
     * @param timestamp the timestamp to set
     */
    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    /**
     * @return Integer return the status
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * @return String return the erro
     */
    public String getErro() {
        return erro;
    }

    /**
     * @param erro the erro to set
     */
    public void setErro(String erro) {
        this.erro = erro;
    }

    /**
     * @return List<String> return the mensagens
     */
    public List<String> getMensagens() {
        return mensagens;
    }

    /**
     * @param mensagens the mensagens to set
     */
    public void setMensagens(List<String> mensagens) {
        this.mensagens = mensagens;
    }

}