package com.example.cuenta_movimientos_service.repository;

import com.example.cuenta_movimientos_service.model.Cuenta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CuentaRepository extends JpaRepository<Cuenta, Long> {
}
