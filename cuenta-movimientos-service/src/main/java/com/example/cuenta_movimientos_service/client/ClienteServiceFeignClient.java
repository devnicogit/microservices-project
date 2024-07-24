package com.example.cuenta_movimientos_service.client;

import com.example.cuenta_movimientos_service.dto.ClienteDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "cliente-persona-service")
public interface ClienteServiceFeignClient {

    @GetMapping("/clientes/{clientId}")
    ClienteDTO getClienteById(@PathVariable("clientId") Long clientId);
}
