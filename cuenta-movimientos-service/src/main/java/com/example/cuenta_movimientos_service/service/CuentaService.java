package com.example.cuenta_movimientos_service.service;

import com.example.cuenta_movimientos_service.client.ClienteServiceFeignClient;
import com.example.cuenta_movimientos_service.dto.ClienteDTO;
import com.example.cuenta_movimientos_service.exception.ResourceNotFoundException;
import com.example.cuenta_movimientos_service.model.Cuenta;
import com.example.cuenta_movimientos_service.repository.CuentaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CuentaService {
    @Autowired
    private CuentaRepository cuentaRepository;
    @Autowired
    private ClienteServiceFeignClient clienteServiceFeignClient;

    public List<Cuenta> getAllCuentas() {
        return cuentaRepository.findAll();
    }

    public Cuenta createCuenta(Cuenta cuenta) {

        ClienteDTO clienteDTO = clienteServiceFeignClient.getClienteById(cuenta.getClienteId());
        if (clienteDTO == null) {
            throw new RuntimeException("Cliente no encontrado");
        }
        return cuentaRepository.save(cuenta);
    }

    public Cuenta updateCuenta(Long id, Cuenta cuenta) {
        Cuenta existingCuenta = cuentaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Cuenta no encontrada"));
        existingCuenta.setNumeroCuenta(cuenta.getNumeroCuenta());
        existingCuenta.setTipoCuenta(cuenta.getTipoCuenta());
        existingCuenta.setSaldoInicial(cuenta.getSaldoInicial());
        existingCuenta.setEstado(cuenta.isEstado());
        return cuentaRepository.save(existingCuenta);
    }

    public void deleteCuenta(Long id) {
        cuentaRepository.deleteById(id);
    }
}