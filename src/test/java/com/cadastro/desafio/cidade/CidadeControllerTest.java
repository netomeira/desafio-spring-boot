package com.cadastro.desafio.cidade;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.fasterxml.jackson.databind.ObjectMapper;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
public class CidadeControllerTest {

    @Autowired
    public MockMvc mockMvc;
    
    @Test
	public void testBuscarCidadePorId() throws Exception {
		mockMvc.perform(get("/cidade/1"))
				.andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }
    
    @Test
    public void testBuscarCidadePorNomeEstado() throws Exception {
        mockMvc.perform(get("/cidade")
				.param("nome", "Recife")
				.param("estado", "Pernambuco"))
				.andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }

    @Test
    public void testBuscarCidadePorNome() throws Exception {
        mockMvc.perform(get("/cidade")
				.param("nome", "Recife"))
				.andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }

    @Test
    public void testBuscarCidadePorEstado() throws Exception {
        mockMvc.perform(get("/cidade")
                .param("estado", "Pernambuco"))
				.andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }

    @Test
    public void testCadastrarCidade() throws Exception {
        mockMvc.perform(post("/cidade")
                .content(asJsonString(new CidadeDTO("Cidade Teste", "Estado Teste")))
                .contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isCreated())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }

    @Test
    public void testCadastrarCidadeComDadosInvalidos() throws Exception {
        mockMvc.perform(post("/cidade")
                .content(asJsonString(new CidadeDTO(null, "Estado Teste")))
                .contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isBadRequest())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }

    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
