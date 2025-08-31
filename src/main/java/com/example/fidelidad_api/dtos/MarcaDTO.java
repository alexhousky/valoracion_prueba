package com.example.fidelidad_api.dtos;

public class MarcaDTO {
    private Long id;
    private String nombre;

    public MarcaDTO(Long id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public Long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }
}



