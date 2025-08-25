package com.example.fidelidad_api.controller;

import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/ciudades")
public class CiudadController {

    private final CiudadService ciudadService;

    public CiudadController(CiudadService ciudadService) {
        this.ciudadService = ciudadService;
    }

    @GetMapping("/listar")
    public List<Ciudad> listarCiudades(@RequestParam(required = false) Integer departamentoId) {
        if(departamentoId != null) {
            return ciudadService.listarPorDepartamento(departamentoId);
        }
        return ciudadService.listarTodas();
    }
}
