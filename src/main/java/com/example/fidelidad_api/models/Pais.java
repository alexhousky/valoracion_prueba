package com.example.fidelidad_api.models;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "paises")
public class Pais {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_pais")
    private Long idPais;

    @Column(name = "nombre_pais", nullable = false, length = 100)
    private String nombrePais;

    // Relación con Departamentos
    @OneToMany(mappedBy = "pais", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Departamento> departamentos;

    // Getters y Setters
    public Long getIdPais() {
        return idPais;
    }

    public void setIdPais(Long idPais) {
        this.idPais = idPais;
    }

    public String getNombrePais() {
        return nombrePais;
    }

    public void setNombrePais(String nombrePais) {
        this.nombrePais = nombrePais;
    }

    public List<Departamento> getDepartamentos() {
        return departamentos;
    }

    public void setDepartamentos(List<Departamento> departamentos) {
        this.departamentos = departamentos;
    }
}
