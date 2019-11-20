package com.cadastro.desafio.cliente;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

    private ClienteService clienteService;

    @Autowired
    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cliente> buscarPorId(@PathVariable("id") Long id) throws Exception {
        return ResponseEntity.ok(clienteService.buscarPorId(id));
    }

    @GetMapping
    public ResponseEntity<List<Cliente>> buscar(@RequestParam(required = false) String nome,
            @RequestParam(required = false) String estado) {
        return ResponseEntity.ok(clienteService.buscar(nome, estado));
    }

    @PostMapping
    public ResponseEntity<Cliente> cadastrar(@Valid @RequestBody ClienteDTO cidade) {
        Cliente novoCliente = clienteService.cadastrar(cidade);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(novoCliente.getId()).toUri();
        return ResponseEntity.created(location).body(novoCliente);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Cliente> editar(@PathVariable("id") Long id, @Valid @RequestBody ClienteDTO cidade) {
        return ResponseEntity.ok(clienteService.editar(id, cidade));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> remover(@PathVariable("id") Long id) {
        clienteService.remover(id);

        return ResponseEntity.noContent().build();
    }

}