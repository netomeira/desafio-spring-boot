package com.cadastro.desafio.cliente;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

    private ClienteService clienteService;

    @Autowired
    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @GetMapping("/{id}")
    public Cliente buscarPorId(@PathVariable("id") Long id) throws Exception {
        return clienteService.buscarPorId(id);
    }

    @GetMapping
    public List<Cliente> buscar(@RequestParam(required = false) String nome,
            @RequestParam(required = false) String estado) {
        return clienteService.buscar(nome, estado);
    }

    @PostMapping
    public void cadastrar(@Valid @RequestBody ClienteTO cidade) {
        clienteService.cadastrar(cidade);
    }

    @PutMapping("/{id}")
    public void editar(@PathVariable("id") Long id, @Valid @RequestBody ClienteTO cidade) {
        clienteService.editar(id, cidade);
    }

    @DeleteMapping("/{id}")
    public void remover(@PathVariable("id") Long id){
        clienteService.remover(id);
    }

}