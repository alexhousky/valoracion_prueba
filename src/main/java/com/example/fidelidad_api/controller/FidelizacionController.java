package com.example.fidelidad_api.controller;

import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/fidelizacion")
public class FidelizacionController {

    private final FidelizacionService fidelizacionService;

    public FidelizacionController(FidelizacionService fidelizacionService) {
        this.fidelizacionService = fidelizacionService;
    }

    @PostMapping("/registrar")
    public Fidelizacion registrar(@RequestBody Fidelizacion fidelizacion) {
        return fidelizacionService.registrarFidelizacion(fidelizacion);
    }

    @GetMapping("/listar")
    public List<Fidelizacion> listarFidelizaciones() {
        return fidelizacionService.listarFidelizaciones();
    }
}


