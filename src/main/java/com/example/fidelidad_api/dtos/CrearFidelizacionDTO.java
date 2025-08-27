package com.example.fidelidad_api.dtos;

import jakarta.validation.constraints.NotNull;
import java.time.LocalDate;

public class CrearFidelizacionDTO {

    @NotNull
    private Integer clienteId;

    @NotNull
    private Integer marcaId;

    private LocalDate fechaInicio; // opcional; por defecto hoy si viene null

    // Getters y setters
    public Integer getClienteId() { return clienteId; }
    public void setClienteId(Integer clienteId) { this.clienteId = clienteId; }
    public Integer getMarcaId() { return marcaId; }
    public void setMarcaId(Integer marcaId) { this.marcaId = marcaId; }
    public LocalDate getFechaInicio() { return fechaInicio; }
    public void setFechaInicio(LocalDate fechaInicio) { this.fechaInicio = fechaInicio; }
}
