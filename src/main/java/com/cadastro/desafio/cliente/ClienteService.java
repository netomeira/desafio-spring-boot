package com.cadastro.desafio.cliente;

import static com.cadastro.desafio.cliente.ClienteSpecification.likeNome;
import static org.springframework.data.jpa.domain.Specification.where;

import java.sql.Date;
import java.util.List;

import com.cadastro.desafio.Utils;
import com.cadastro.desafio.excecao.NaoEncontradoException;

import org.springframework.stereotype.Service;

@Service
public class ClienteService {

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

    public void cadastrar(ClienteTO clienteTO){
        Cliente cliente = new Cliente();

        Date dataNascimento = Date.valueOf(clienteTO.getDataNascimento());
        
        cliente.setNome(clienteTO.getNome());
        cliente.setGenero(Genero.get(clienteTO.getGenero()));
        cliente.setDataNascimento(dataNascimento);
        cliente.setIdade(Utils.calcularIdade(dataNascimento.toLocalDate()));
        cliente.setCidade(clienteTO.getCidade());

        clienteRepository.save(cliente);
    }

    public void editar(Long id, ClienteTO clienteTO){
        Cliente cliente = this.buscarPorId(id);

        Date dataNascimento = Date.valueOf(clienteTO.getDataNascimento());
        
        cliente.setNome(clienteTO.getNome());
        cliente.setGenero(Genero.get(clienteTO.getGenero()));
        cliente.setDataNascimento(dataNascimento);
        cliente.setIdade(Utils.calcularIdade(dataNascimento.toLocalDate()));
        cliente.setCidade(clienteTO.getCidade());

        clienteRepository.save(cliente);
    }

    public void remover(Long id){
        clienteRepository.deleteById(id);
    }

}