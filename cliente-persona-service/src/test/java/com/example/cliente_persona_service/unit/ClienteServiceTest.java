package com.example.cliente_persona_service.unit;

import com.example.cliente_persona_service.exception.ResourceNotFoundException;
import com.example.cliente_persona_service.model.Cliente;
import com.example.cliente_persona_service.repository.ClienteRepository;
import com.example.cliente_persona_service.service.ClienteService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest
@ActiveProfiles("test")
public class ClienteServiceTest {

    @Mock
    private ClienteRepository clienteRepository;

    @InjectMocks
    private ClienteService clienteService;

    public ClienteServiceTest() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetClienteById() {
        Cliente cliente = new Cliente();
        cliente.setId(1L);
        when(clienteRepository.findById(1L)).thenReturn(Optional.of(cliente));

        Cliente found = clienteService.getClienteById(1L);
        assertNotNull(found);
        assertEquals(cliente.getId(), found.getId());
    }

    @Test
    public void testGetClienteByIdNotFound() {
        when(clienteRepository.findById(1L)).thenReturn(Optional.empty());
        assertThrows(ResourceNotFoundException.class, () -> clienteService.getClienteById(1L));
    }
}