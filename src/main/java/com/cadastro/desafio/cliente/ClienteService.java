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

    public Cliente cadastrar(ClienteDTO clienteDTO) {
        Cliente novoCliente = new Cliente();
        mapear(clienteDTO, novoCliente);

        return clienteRepository.save(novoCliente);
    }

    public Cliente editar(Long id, ClienteDTO clienteDTO) {
        Cliente cliente = this.buscarPorId(id);
        mapear(clienteDTO, cliente);

        return clienteRepository.save(cliente);
    }

    public void remover(Long id) {
        clienteRepository.deleteById(id);
    }

    private void mapear(ClienteDTO clienteDTO, Cliente cliente){
        cliente.setNome(clienteDTO.getNome());
        cliente.setGenero(Genero.get(clienteDTO.getGenero()));
        cliente.setDataNascimento(clienteDTO.getDataNascimento());
        cliente.setCidade(cidadeRepository.findById(clienteDTO.getCidadeId()).orElseThrow(NaoEncontradoException::new));
    }

}