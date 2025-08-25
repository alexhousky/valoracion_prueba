package com.example.fidelidad_api.controller;

import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/tipo_identificacion")
public class TipoIdentificacionController {

    private final TipoIdentificacionService tipoIdentificacionService;

    public TipoIdentificacionController(TipoIdentificacionService tipoIdentificacionService) {
        this.tipoIdentificacionService = tipoIdentificacionService;
    }

    @GetMapping("/listar")
    public List<TipoIdentificacion> listarTipos() {
        return tipoIdentificacionService.listarTipos();
    }
}

