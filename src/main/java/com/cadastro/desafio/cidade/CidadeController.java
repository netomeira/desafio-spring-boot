package com.cadastro.desafio.cidade;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cidade")
public class CidadeController {

    private CidadeRepository cidadeRepository;

    @Autowired
    public CidadeController(CidadeRepository cidadeRepository){
        this.cidadeRepository = cidadeRepository;
    }

    @GetMapping("/{id}")
    public Cidade buscarPorId(@PathVariable("id") Long id) throws Exception {
        return cidadeRepository.findById(id).orElseThrow(Exception::new);
    }

    @GetMapping
    public List<Cidade> buscar(@RequestParam String nome,
                               @RequestParam String estado){
        return cidadeRepository.findByNomeAndEstado(nome, estado);
    }

    @PostMapping
    public void cadastrar(@Valid @RequestBody CidadeTO cidade){
        Cidade novaCidade = new Cidade();
        novaCidade.setNome(cidade.getNome());
        novaCidade.setEstado(cidade.getEstado());

        cidadeRepository.save(novaCidade);
    }

    @PutMapping("/{id}")
    public void editar(@PathVariable("id") Long id, @Valid @RequestBody CidadeTO cidade){
    }

}