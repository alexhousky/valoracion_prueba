package com.example.fidelidad_api.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "tipo_identificacion")
@Data
public class TipoIdentificacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_identificacion")
    private Integer idIdentificacion;

    @Column(name = "nombre_identificacion", nullable = false, length = 100)
    private String nombreIdentificacion;

    public Integer getIdIdentificacion() {
        return idIdentificacion;
    }

    public void setIdIdentificacion(Integer idIdentificacion) {
        this.idIdentificacion = idIdentificacion;
    }

    public String getNombreIdentificacion() {
        return nombreIdentificacion;
    }

    public void setNombreIdentificacion(String nombreIdentificacion) {
        this.nombreIdentificacion = nombreIdentificacion;
    }
}

