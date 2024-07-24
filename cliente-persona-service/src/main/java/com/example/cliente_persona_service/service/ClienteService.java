package com.example.cliente_persona_service.service;

import com.example.cliente_persona_service.exception.ResourceNotFoundException;
import com.example.cliente_persona_service.model.Cliente;
import com.example.cliente_persona_service.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {
    @Autowired
    private ClienteRepository clienteRepository;

    public List<Cliente> getAllClientes() {
        return clienteRepository.findAll();
    }

    public Cliente getClienteById(Long id) {
        return clienteRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Cliente no encontrado"));
    }

    public Cliente createCliente(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    public Cliente updateCliente(Long id, Cliente cliente) {
        Cliente existingCliente = clienteRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Cliente no encontrado"));
        existingCliente.setClientId(cliente.getClientId());
        existingCliente.setContrasena(cliente.getContrasena());
        existingCliente.setEstado(cliente.isEstado());
        return clienteRepository.save(existingCliente);
    }

    public void deleteCliente(Long id) {
        clienteRepository.deleteById(id);
    }
}

