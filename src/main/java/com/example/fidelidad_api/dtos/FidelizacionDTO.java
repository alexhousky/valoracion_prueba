// src/main/java/com/example/fidelidad_api/dtos/FidelizacionDTO.java
package com.example.fidelidad_api.dtos;

import com.example.fidelidad_api.models.EstadoFidelizacion;

import java.time.LocalDate;

public class FidelizacionDTO {
    private Integer id;
    private Integer clienteId;
    private String clienteNombreCompleto;
    private Integer marcaId;
    private String marcaNombre;
    private LocalDate fechaInicio;
    private EstadoFidelizacion estado;

    // Getters y setters
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }
    public Integer getClienteId() { return clienteId; }
    public void setClienteId(Integer clienteId) { this.clienteId = clienteId; }
    public String getClienteNombreCompleto() { return clienteNombreCompleto; }
    public void setClienteNombreCompleto(String clienteNombreCompleto) { this.clienteNombreCompleto = clienteNombreCompleto; }
    public Integer getMarcaId() { return marcaId; }
    public void setMarcaId(Integer marcaId) { this.marcaId = marcaId; }
    public String getMarcaNombre() { return marcaNombre; }
    public void setMarcaNombre(String marcaNombre) { this.marcaNombre = marcaNombre; }
    public LocalDate getFechaInicio() { return fechaInicio; }
    public void setFechaInicio(LocalDate fechaInicio) { this.fechaInicio = fechaInicio; }
    public EstadoFidelizacion getEstado() { return estado; }
    public void setEstado(EstadoFidelizacion estado) { this.estado = estado; }
}
