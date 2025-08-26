package com.example.fidelidad_api.models;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "tipo_identificacion")
public class TipoIdentificacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_identificacion")
    private Long idIdentificacion;

    @Column(name = "nombre_identificacion", nullable = false, length = 50)
    private String nombreIdentificacion;

    // Relación con Clientes
    @OneToMany(mappedBy = "tipoIdentificacion", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Cliente> clientes;

    // Getters y Setters
    public Long getIdIdentificacion() {
        return idIdentificacion;
    }

    public void setIdIdentificacion(Long idIdentificacion) {
        this.idIdentificacion = idIdentificacion;
    }

    public String getNombreIdentificacion() {
        return nombreIdentificacion;
    }

    public void setNombreIdentificacion(String nombreIdentificacion) {
        this.nombreIdentificacion = nombreIdentificacion;
    }

    public List<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(List<Cliente> clientes) {
        this.clientes = clientes;
    }
}
