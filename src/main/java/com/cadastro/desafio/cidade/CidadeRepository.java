package com.cadastro.desafio.cidade;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CidadeRepository extends JpaRepository<Cidade, Long>{

    List<Cidade> findByNomeAndEstado(String nome, String estado);

}