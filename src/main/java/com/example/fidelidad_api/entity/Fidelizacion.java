package com.example.fidelidad_api.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "fidelizacion")
public class Fidelizacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_fidelizacion")
    private Long idFidelizacion;

    @ManyToOne
    @JoinColumn(name = "cliente", nullable = false)
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "marca", nullable = false)
    private Marca marca;

    // Getters y Setters

    public Long getIdFidelizacion() {
        return idFidelizacion;
    }

    public void setIdFidelizacion(Long idFidelizacion) {
        this.idFidelizacion = idFidelizacion;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Marca getMarca() {
        return marca;
    }

    public void setMarca(Marca marca) {
        this.marca = marca;
    }
}

