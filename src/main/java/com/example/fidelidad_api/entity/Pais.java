package com.example.fidelidad_api.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "paises")
@Getter
@Setter
public class Pais {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_paises")
    private Integer idPaises;

    @Column(name = "nombre", nullable = false, length = 100)
    private String nombre;
}


