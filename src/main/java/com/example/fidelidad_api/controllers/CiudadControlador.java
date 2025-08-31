package com.example.fidelidad_api.controllers;

import com.example.fidelidad_api.models.Ciudad;
import com.example.fidelidad_api.services.CiudadServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/ciudades")
public class CiudadControlador {

    @Autowired
    private CiudadServicio ciudadServicio;

    @GetMapping("/departamento/{departamentoId}")
    public List<Ciudad> listarPorDepartamento(@PathVariable Long departamentoId) {
        return ciudadServicio.listarPorDepartamento(departamentoId);
    }
}
