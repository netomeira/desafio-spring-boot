package com.cadastro.desafio.cliente;

import static com.cadastro.desafio.cliente.ClienteSpecification.likeNome;
import static org.springframework.data.jpa.domain.Specification.where;

import java.util.List;

import com.cadastro.desafio.cidade.CidadeRepository;
import com.cadastro.desafio.excecao.NaoEncontradoException;

import org.springframework.stereotype.Service;

@Service
public class ClienteService {

    private ClienteRepository clienteRepository;

    private CidadeRepository cidadeRepository;

    public ClienteService(ClienteRepository clienteRepository, CidadeRepository cidadeRepository) {
        this.clienteRepository = clienteRepository;
        this.cidadeRepository = cidadeRepository;
    }

    public Cliente buscarPorId(Long id) {
        return clienteRepository.findById(id).orElseThrow(NaoEncontradoException::new);
    }

    public List<Cliente> buscar(String nome, String estado) {
        return clienteRepository.findAll(where(likeNome(nome)));
    }

    public Cliente cadastrar(ClienteTO clienteTO) {
        Cliente novoCliente = new Cliente();
        mapear(clienteTO, novoCliente);

        return clienteRepository.save(novoCliente);
    }

    public Cliente editar(Long id, ClienteTO clienteTO) {
        Cliente cliente = this.buscarPorId(id);
        mapear(clienteTO, cliente);

        return clienteRepository.save(cliente);
    }

    public void remover(Long id) {
        clienteRepository.deleteById(id);
    }

    private void mapear(ClienteTO clienteTO, Cliente cliente){
        cliente.setNome(clienteTO.getNome());
        cliente.setGenero(Genero.get(clienteTO.getGenero()));
        cliente.setDataNascimento(clienteTO.getDataNascimento());
        cliente.setCidade(cidadeRepository.findById(clienteTO.getCidadeId()).orElseThrow(NaoEncontradoException::new));
    }

}