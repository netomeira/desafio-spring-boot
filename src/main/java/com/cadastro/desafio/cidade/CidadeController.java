package com.cadastro.desafio.cidade;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cidade")
public class CidadeController {

    private CidadeService cidadeService;

    @Autowired
    public CidadeController(CidadeService cidadeService) {
        this.cidadeService = cidadeService;
    }
    
    @GetMapping
    public List<Cidade> buscar(@RequestParam(required = false) String nome,
            @RequestParam(required = false) String estado) {
        return cidadeService.buscar(nome, estado);
    }

    @PostMapping
    public void cadastrar(@Valid @RequestBody CidadeTO cidade) {
        cidadeService.cadastrar(cidade);
    }

}