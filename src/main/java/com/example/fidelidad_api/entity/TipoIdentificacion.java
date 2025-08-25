package com.example.fidelidad_api.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "tipo_identificacion")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TipoIdentificacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 50)
    private String nombre;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
