package com.example.fidelidad_api.dtos;

import com.example.fidelidad_api.models.EstadoFidelizacion;
import jakarta.validation.constraints.NotNull;

public class ActualizarEstadoFidelizacionDTO {

    @NotNull
    private EstadoFidelizacion estado;

    public EstadoFidelizacion getEstado() { return estado; }
    public void setEstado(EstadoFidelizacion estado) { this.estado = estado; }
}
