package com.example.fidelidad_api.controller;

import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/marcas")
public class MarcaController {

    private final MarcaService marcaService;

    public MarcaController(MarcaService marcaService) {
        this.marcaService = marcaService;
    }

    @GetMapping("/listar")
    public List<Marca> listarMarcas() {
        return marcaService.listarMarcas();
    }
}

