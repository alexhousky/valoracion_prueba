package com.example.fidelidad_api.models;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(
        name = "fidelizacion",
        uniqueConstraints = @UniqueConstraint(name = "uk_fidelizacion_cliente_marca", columnNames = {"cliente_id", "marca_id"})
)
public class Fidelizacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "cliente_id", nullable = false, foreignKey = @ForeignKey(name = "fk_fidelizacion_cliente"))
    private Cliente cliente;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "marca_id", nullable = false, foreignKey = @ForeignKey(name = "fk_fidelizacion_marca"))
    private Marca marca;

    @Column(name = "fecha_inicio", nullable = false)
    private LocalDate fechaInicio;

    @Enumerated(EnumType.STRING)
    @Column(name = "estado", nullable = false, length = 20)
    private EstadoFidelizacion estado = EstadoFidelizacion.ACTIVO;

    @PrePersist
    public void prePersist() {
        if (fechaInicio == null) {
            fechaInicio = LocalDate.now();
        }
        if (estado == null) {
            estado = EstadoFidelizacion.ACTIVO;
        }
    }

    // Getters y setters
    public Integer getId() { return id; }
    public Cliente getCliente() { return cliente; }
    public void setCliente(Cliente cliente) { this.cliente = cliente; }
    public Marca getMarca() { return marca; }
    public void setMarca(Marca marca) { this.marca = marca; }
    public LocalDate getFechaInicio() { return fechaInicio; }
    public void setFechaInicio(LocalDate fechaInicio) { this.fechaInicio = fechaInicio; }
    public EstadoFidelizacion getEstado() { return estado; }
    public void setEstado(EstadoFidelizacion estado) { this.estado = estado; }
}
