package com.example.fidelidad_api.models;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "ciudades")
public class Ciudad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_ciudad", columnDefinition = "BIGINT")
    private Long idCiudad;

    @Column(name = "nombre_ciudad", nullable = false, length = 100)
    private String nombreCiudad;

    // Relación con Departamento
    @ManyToOne
    @JoinColumn(name = "departamento_id", nullable = false)
    private Departamento departamento;

    // Relación con Clientes
    @OneToMany(mappedBy = "ciudad", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Cliente> clientes;

    // Getters y Setters
    public Long getIdCiudad() {
        return idCiudad;
    }

    public void setIdCiudad(Long idCiudad) {
        this.idCiudad = idCiudad;
    }

    public String getNombreCiudad() {
        return nombreCiudad;
    }

    public void setNombreCiudad(String nombreCiudad) {
        this.nombreCiudad = nombreCiudad;
    }

    public Departamento getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }

    public List<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(List<Cliente> clientes) {
        this.clientes = clientes;
    }
}
