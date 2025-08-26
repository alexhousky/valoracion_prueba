package com.example.fidelidad_api.models;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "marcas")
public class Marca {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_marcas")
    private Long idMarcas;

    @Column(name = "nombre_marca", nullable = false, length = 50)
    private String nombreMarca;

    // Relación con Clientes
    @OneToMany(mappedBy = "marca", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Cliente> clientes;

    // Relación con Fidelización
    @OneToMany(mappedBy = "marca", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Fidelizacion> fidelizaciones;

    // Getters y Setters
    public Long getIdMarcas() {
        return idMarcas;
    }

    public void setIdMarcas(Long idMarcas) {
        this.idMarcas = idMarcas;
    }

    public String getNombreMarca() {
        return nombreMarca;
    }

    public void setNombreMarca(String nombreMarca) {
        this.nombreMarca = nombreMarca;
    }

    public List<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(List<Cliente> clientes) {
        this.clientes = clientes;
    }

    public List<Fidelizacion> getFidelizaciones() {
        return fidelizaciones;
    }

    public void setFidelizaciones(List<Fidelizacion> fidelizaciones) {
        this.fidelizaciones = fidelizaciones;
    }
}
