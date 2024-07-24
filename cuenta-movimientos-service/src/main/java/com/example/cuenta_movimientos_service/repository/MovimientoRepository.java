package com.example.cuenta_movimientos_service.repository;

import com.example.cuenta_movimientos_service.model.Movimiento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovimientoRepository extends JpaRepository<Movimiento, Long> {
}
