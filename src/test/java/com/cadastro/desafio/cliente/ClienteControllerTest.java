package com.cadastro.desafio.cliente;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Date;

import com.fasterxml.jackson.databind.ObjectMapper;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
public class ClienteControllerTest {

    @Autowired
    public MockMvc mockMvc;
    
    @Test
	public void testBuscarClientePorId() throws Exception {
		mockMvc.perform(get("/cliente/2"))
				.andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }
    
    @Test
    public void testBuscarTodosClientes() throws Exception {
        mockMvc.perform(get("/cliente"))
				.andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }

    @Test
    public void testBuscarClientePorNomeEstado() throws Exception {
        mockMvc.perform(get("/cliente")
				.param("nome", "Neto")
				.param("estado", "Pernambuco"))
				.andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }

    @Test
    public void testBuscarClientePorNome() throws Exception {
        mockMvc.perform(get("/cliente")
				.param("nome", "Neto"))
				.andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }

    @Test
    public void testBuscarClientePorEstado() throws Exception {
        mockMvc.perform(get("/cliente")
                .param("estado", "Pernambuco"))
				.andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }

    @Test
    public void testCadastrarCliente() throws Exception {
        mockMvc.perform(post("/cliente")
                .content(asJsonString(new ClienteDTO("Cliente Teste", "M", new Date(), 1L)))
                .contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isCreated())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }

    @Test
    public void testEditarCliente() throws Exception {
        mockMvc.perform(put("/cliente/2")
                .content(asJsonString(new ClienteDTO("Cliente Teste", "M", new Date(), 1L)))
                .contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }

    @Test
    public void testRemoverCliente() throws Exception {
        mockMvc.perform(delete("/cliente/1"))
				.andExpect(status().isNoContent());
    }

    @Test
    public void testCadastrarClienteComDadosInvalidos() throws Exception {
        mockMvc.perform(post("/cliente")
                .content(asJsonString(new ClienteDTO(null, "M", new Date(), 1L)))
                .contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isBadRequest())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }

    @Test
    public void testEditarClienteInvalido() throws Exception {
        mockMvc.perform(put("/cliente/999")
                .content(asJsonString(new ClienteDTO("Cliente Teste", "M", new Date(), 1L)))
                .contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isNotFound())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }

    @Test
    public void testRemoverClienteInvalido() throws Exception {
        mockMvc.perform(delete("/cliente/999"))
				.andExpect(status().isBadRequest());
    }

    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
