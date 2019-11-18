package com.cadastro.desafio.cidade;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.StringUtils;

public class CidadeSpecification {

    public static Specification<Cidade> likeNome(String nome) {
        if (StringUtils.isEmpty(nome)) {
            return null;
        }
        return (root, query, cb) ->
            cb.like(root.get("nome"), "%" + nome + "%");
    }
    
    public static Specification<Cidade> likeEstado(String estado) {
        if (StringUtils.isEmpty(estado)) {
            return null;
        }
        return (root, query, cb) ->
            cb.like(root.get("estado"), "%" + estado + "%");
    }

}