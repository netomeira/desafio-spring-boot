package com.cadastro.desafio.cidade;

import static com.cadastro.desafio.cidade.CidadeSpecification.likeEstado;
import static com.cadastro.desafio.cidade.CidadeSpecification.likeNome;
import static org.springframework.data.jpa.domain.Specification.where;

import java.util.List;

import com.cadastro.desafio.excecao.NaoEncontradoException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CidadeService {

    private CidadeRepository cidadeRepository;

    @Autowired
    public CidadeService(CidadeRepository cidadeRepository) {
        this.cidadeRepository = cidadeRepository;
    }

    public Cidade buscarPorId(Long id) {
        return cidadeRepository.findById(id).orElseThrow(NaoEncontradoException::new);
    }

    public List<Cidade> buscar(String nome, String estado) {
        return cidadeRepository.findAll(where(likeNome(nome)).and(likeEstado(estado)));
    }

    public Cidade cadastrar(CidadeDTO cidadeDTO){
        Cidade novaCidade = new Cidade();
        novaCidade.setNome(cidadeDTO.getNome());
        novaCidade.setEstado(cidadeDTO.getEstado());

        return cidadeRepository.save(novaCidade);
    }

}