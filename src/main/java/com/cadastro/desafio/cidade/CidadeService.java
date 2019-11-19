package com.cadastro.desafio.cidade;

import static com.cadastro.desafio.cidade.CidadeSpecification.likeEstado;
import static com.cadastro.desafio.cidade.CidadeSpecification.likeNome;
import static org.springframework.data.jpa.domain.Specification.where;

import java.util.List;

import com.cadastro.desafio.excecao.NaoEncontradoException;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CidadeService {

    @Autowired
    private ModelMapper modelMapper;

    private CidadeRepository cidadeRepository;

    public CidadeService(CidadeRepository cidadeRepository) {
        this.cidadeRepository = cidadeRepository;
    }

    public Cidade buscarPorId(Long id) {
        return cidadeRepository.findById(id).orElseThrow(NaoEncontradoException::new);
    }

    public List<Cidade> buscar(String nome, String estado) {
        return cidadeRepository.findAll(where(likeNome(nome)).and(likeEstado(estado)));
    }

    public Cidade cadastrar(CidadeTO cidadeTO){
        return cidadeRepository.save(modelMapper.map(cidadeTO, Cidade.class));
    }

}