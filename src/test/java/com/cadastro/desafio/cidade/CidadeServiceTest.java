package com.cadastro.desafio.cidade;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class CidadeServiceTest {

    @Mock
    private CidadeRepository cidadeRepository;

    private CidadeService cidadeService;

    @BeforeEach
    void setup() {
        cidadeService = new CidadeService(cidadeRepository);
    }

    @Test
    public void testarCadastrarCidade() {
        when(cidadeRepository.save(any(Cidade.class))).thenReturn(new Cidade(1L, "Cidade Teste", "Estado Teste"));

        Cidade cidade = cidadeService.cadastrar(new CidadeTO());

        assertNotNull(cidade);
        assert(cidade.getNome().equalsIgnoreCase("Cidade Teste"));
        assert(cidade.getEstado().equalsIgnoreCase("Estado Teste"));
    }

    @Test
    public void testarBuscarPorId() {
        when(cidadeRepository.findById(anyLong())).thenReturn(Optional.of(new Cidade()));

        Cidade cidade = cidadeService.buscarPorId(1L);

        assertNotNull(cidade);
    }

}