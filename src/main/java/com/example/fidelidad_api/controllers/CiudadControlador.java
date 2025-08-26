package com.example.fidelidad_api.controllers;

import com.example.fidelidad_api.models.Ciudad;
import com.example.fidelidad_api.services.CiudadServicio;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ciudades")
@CrossOrigin(origins = "*")
public class CiudadControlador {
    private final CiudadServicio ciudadServicio;

    public CiudadControlador(CiudadServicio ciudadServicio) {
        this.ciudadServicio = ciudadServicio;
    }

    @GetMapping
    public List<Ciudad> listar() {
        return ciudadServicio.listarCiudades();
    }

    @GetMapping("/{id}")
    public Ciudad obtener(@PathVariable Integer id) {
        return ciudadServicio.buscarPorId(id);
    }
}
