package com.cadastro.desafio.cliente;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.StringUtils;

public class ClienteSpecification {

    public static Specification<Cliente> likeNome(String nome) {
        if (StringUtils.isEmpty(nome)) {
            return null;
        }
        return (root, query, cb) ->
            cb.like(root.get("nome"), "%" + nome + "%");
    }
    
}