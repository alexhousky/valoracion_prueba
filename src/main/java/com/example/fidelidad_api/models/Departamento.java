package com.example.fidelidad_api.models;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "departamentos")
public class Departamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_departamento")
    private Long idDepartamento;

    @Column(name = "nombre_departamento", nullable = false, length = 100)
    private String nombreDepartamento;

    // Relación con País
    @ManyToOne
    @JoinColumn(name = "pais_id", nullable = false)
    private Pais pais;

    // Relación con Ciudades
    @OneToMany(mappedBy = "departamento", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Ciudad> ciudades;

    // Getters y Setters
    public Long getIdDepartamento() {
        return idDepartamento;
    }

    public void setIdDepartamento(Long idDepartamento) {
        this.idDepartamento = idDepartamento;
    }

    public String getNombreDepartamento() {
        return nombreDepartamento;
    }

    public void setNombreDepartamento(String nombreDepartamento) {
        this.nombreDepartamento = nombreDepartamento;
    }

    public Pais getPais() {
        return pais;
    }

    public void setPais(Pais pais) {
        this.pais = pais;
    }

    public List<Ciudad> getCiudades() {
        return ciudades;
    }

    public void setCiudades(List<Ciudad> ciudades) {
        this.ciudades = ciudades;
    }
}
