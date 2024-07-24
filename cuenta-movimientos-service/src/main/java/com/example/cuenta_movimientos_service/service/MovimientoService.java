package com.example.cuenta_movimientos_service.service;

import com.example.cuenta_movimientos_service.exception.InsufficientFundsException;
import com.example.cuenta_movimientos_service.exception.ResourceNotFoundException;
import com.example.cuenta_movimientos_service.model.Cuenta;
import com.example.cuenta_movimientos_service.model.Movimiento;
import com.example.cuenta_movimientos_service.repository.CuentaRepository;
import com.example.cuenta_movimientos_service.repository.MovimientoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovimientoService {
    @Autowired
    private MovimientoRepository movimientoRepository;
    @Autowired
    private CuentaRepository cuentaRepository;

    public List<Movimiento> getAllMovimientos() {
        return movimientoRepository.findAll();
    }

    public Movimiento createMovimiento(Movimiento movimiento) {
        Cuenta cuenta = cuentaRepository.findById(movimiento.getCuenta().getId())
                .orElseThrow(() -> new ResourceNotFoundException("Cuenta no encontrada"));
        if (movimiento.getValor().compareTo(cuenta.getSaldoInicial()) > 0) {
            throw new InsufficientFundsException("Saldo no disponible");
        }
        cuenta.setSaldoInicial(cuenta.getSaldoInicial().subtract(movimiento.getValor()));
        movimiento.setSaldo(cuenta.getSaldoInicial());
        cuentaRepository.save(cuenta);
        return movimientoRepository.save(movimiento);
    }

    public Movimiento updateMovimiento(Long id, Movimiento movimiento) {
        Movimiento existingMovimiento = movimientoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Movimiento no encontrado"));
        existingMovimiento.setFecha(movimiento.getFecha());
        existingMovimiento.setTipoMovimiento(movimiento.getTipoMovimiento());
        existingMovimiento.setValor(movimiento.getValor());
        existingMovimiento.setSaldo(movimiento.getSaldo());
        return movimientoRepository.save(existingMovimiento);
    }

    public void deleteMovimiento(Long id) {
        movimientoRepository.deleteById(id);
    }
}
