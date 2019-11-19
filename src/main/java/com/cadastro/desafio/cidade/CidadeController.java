package com.cadastro.desafio.cidade;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping("/cidade")
public class CidadeController {

    private CidadeService cidadeService;

    @Autowired
    public CidadeController(CidadeService cidadeService) {
        this.cidadeService = cidadeService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cidade> buscarPorId(@PathVariable("id") Long id) throws Exception {
        Cidade cidade = cidadeService.buscarPorId(id);

        return ResponseEntity.ok(cidade);
    }
    
    @GetMapping
    public ResponseEntity<List<Cidade>> buscar(@RequestParam(required = false) String nome,
            @RequestParam(required = false) String estado) {
        List<Cidade> listaResultado = cidadeService.buscar(nome, estado);

        return ResponseEntity.ok(listaResultado);
    }

    @PostMapping
    public ResponseEntity<Cidade> cadastrar(@Valid @RequestBody CidadeTO cidade) {
        Cidade novaCidade = cidadeService.cadastrar(cidade);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(novaCidade.getId()).toUri();
        return ResponseEntity.created(location).body(novaCidade);
    }

}