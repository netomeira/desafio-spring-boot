package com.cadastro.desafio.cidade;

import static com.cadastro.desafio.cidade.CidadeSpecification.likeEstado;
import static com.cadastro.desafio.cidade.CidadeSpecification.likeNome;
import static org.springframework.data.jpa.domain.Specification.where;

import java.util.List;

import com.cadastro.desafio.excecao.NaoEncontradoException;

import org.springframework.stereotype.Service;

@Service
public class CidadeService {

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

    public void cadastrar(CidadeTO cidadeTO){
        Cidade cidade = new Cidade();
        
        cidade.setNome(cidadeTO.getNome());
        cidade.setEstado(cidadeTO.getEstado());

        cidadeRepository.save(cidade);
    }

    public void editar(Long id, CidadeTO cidadeTO){
        Cidade cidade = this.buscarPorId(id);

        cidade.setNome(cidadeTO.getNome());
        cidade.setEstado(cidadeTO.getEstado());

        cidadeRepository.save(cidade);
    }

    public void remover(Long id){
        cidadeRepository.deleteById(id);
    }

}