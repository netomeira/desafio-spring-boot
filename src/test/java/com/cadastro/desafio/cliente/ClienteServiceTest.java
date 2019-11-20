package com.cadastro.desafio.cliente;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

import java.util.Date;
import java.util.Optional;

import com.cadastro.desafio.cidade.Cidade;
import com.cadastro.desafio.cidade.CidadeRepository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class ClienteServiceTest {

    @Mock
    private ClienteRepository clienteRepository;

    @Mock
    private CidadeRepository cidadeRepository;

    private ClienteService clienteService;

    @BeforeEach
    void setup() {
        clienteService = new ClienteService(clienteRepository, cidadeRepository);
    }

    @Test
    public void testBuscarPorId(){
        when(clienteRepository.findById(anyLong())).thenReturn(Optional.of(new Cliente()));

        Cliente cliente = clienteService.buscarPorId(1L);

        assertNotNull(cliente);
    }

    @Test
    public void testarCadastrarCliente() {
        when(clienteRepository.save(any(Cliente.class))).thenReturn(new Cliente(1L, "Cliente Teste", Genero.M, new Date(), new Cidade()));
        when(cidadeRepository.findById(anyLong())).thenReturn(Optional.of(new Cidade()));

        Cliente cliente = clienteService.cadastrar(new ClienteDTO("Cliente Teste", "M", new Date(), 1L));

        assertNotNull(cliente);
        assert(cliente.getNome().equalsIgnoreCase("Cliente Teste"));
    }
}