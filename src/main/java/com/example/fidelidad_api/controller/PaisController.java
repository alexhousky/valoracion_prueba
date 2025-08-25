package com.example.fidelidad_api.controller;

import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/paises")
public class PaisController {

    private final PaisService paisService;

    public PaisController(PaisService paisService) {
        this.paisService = paisService;
    }

    @GetMapping("/listar")
    public List<Pais> listarPaises() {
        return paisService.listarPaises();
    }
}
