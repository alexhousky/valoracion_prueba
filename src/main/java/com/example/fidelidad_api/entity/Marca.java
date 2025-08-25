package com.example.fidelidad_api.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "marcas")
@Getter
@Setter
public class Marca {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_marcas")
    private Integer idMarcas;

    @Column(name = "nombre", nullable = false, length = 100)
    private String nombre;

    public Integer getIdMarcas() {
        return idMarcas;
    }

    public void setIdMarcas(Integer idMarcas) {
        this.idMarcas = idMarcas;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}



