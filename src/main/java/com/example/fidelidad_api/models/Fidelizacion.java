package com.example.fidelidad_api.models;

import jakarta.persistence.*;

@Entity
@Table(name = "fidelizacion")
public class Fidelizacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_fidelizacion")
    private Integer idFidelizacion;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "cliente", referencedColumnName = "id_clientes", nullable = false)
    private Cliente cliente;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "marca_id", referencedColumnName = "id_marcas", nullable = false)
    private Marca marca;

    // ===== Getters & Setters (manuales) =====
    public Integer getIdFidelizacion() {
        return idFidelizacion;
    }

    public void setIdFidelizacion(Integer idFidelizacion) {
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
