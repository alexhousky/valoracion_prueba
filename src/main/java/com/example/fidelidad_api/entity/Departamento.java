package com.example.fidelidad_api.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "departamentos")
public class Departamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String nombre;

    // 🔹 Relación con País (muchos departamentos pertenecen a un país)
    @ManyToOne
    @JoinColumn(name = "pais_id", nullable = false)
    private Pais pais;

    public Departamento() {}

    public Departamento(String nombre, Pais pais) {
        this.nombre = nombre;
        this.pais = pais;
    }

    public Long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Pais getPais() {
        return pais;
    }

    public void setPais(Pais pais) {
        this.pais = pais;
    }
}
