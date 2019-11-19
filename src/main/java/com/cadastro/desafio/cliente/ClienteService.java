package com.cadastro.desafio.cliente;

import static com.cadastro.desafio.cliente.ClienteSpecification.likeNome;
import static org.springframework.data.jpa.domain.Specification.where;

import java.util.List;

import com.cadastro.desafio.excecao.NaoEncontradoException;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {

    @Autowired
    protected ModelMapper modelMapper;
    
    private ClienteRepository clienteRepository;

    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public Cliente buscarPorId(Long id) {
        return clienteRepository.findById(id).orElseThrow(NaoEncontradoException::new);
    }

    public List<Cliente> buscar(String nome, String estado) {
        return clienteRepository.findAll(where(likeNome(nome)));
    }

    public void cadastrar(ClienteTO clienteTO) {
        clienteRepository.save(modelMapper.map(clienteTO, Cliente.class));
    }

    public void editar(Long id, ClienteTO clienteTO) {
        Cliente cliente = this.buscarPorId(id);

        modelMapper.map(clienteTO, cliente);

        clienteRepository.save(cliente);
    }

    public void remover(Long id){
        clienteRepository.deleteById(id);
    }

}