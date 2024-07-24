package com.example.cuenta_movimientos_service.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class ClienteDTO {

    @NotNull(message = "Id del Cliente es Obligatorio")
    private Long clientId;
    @NotBlank(message = "Password es Obligatorio")
    @Size(min = 6, message = "Password debe tener al menos 6 caracteres")
    private String contrasena;

    private boolean estado;

    // Getters y setters

    public Long getClientId() {
        return clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }
}
