package com.example.cliente_persona_service.integration;

import com.example.cliente_persona_service.model.Cliente;
import com.example.cliente_persona_service.repository.ClienteRepository;
import com.example.cliente_persona_service.service.ClienteService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ActiveProfiles("integration-test")
public class ClienteServiceIntegrationTest {

    @Autowired
    private ClienteService clienteService;

    @Autowired
    private ClienteRepository clienteRepository;

    @Test
    public void testCreateAndGetCliente() {
        Cliente cliente = new Cliente();
        cliente.setClientId(123L);
        cliente.setContrasena("password");
        cliente.setEstado(true);

        Cliente savedCliente = clienteService.createCliente(cliente);
        assertNotNull(savedCliente);
        assertNotNull(savedCliente.getId());

        Optional<Cliente> found = clienteRepository.findById(savedCliente.getId());
        assertTrue(found.isPresent());
        assertEquals(savedCliente.getId(), found.get().getId());
    }
}
