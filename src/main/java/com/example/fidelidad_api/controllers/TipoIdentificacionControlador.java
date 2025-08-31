package com.example.fidelidad_api.controllers;

import com.example.fidelidad_api.dtos.TipoIdentificacionDTO;
import com.example.fidelidad_api.services.TipoIdentificacionServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tipo-identificacion")
public class TipoIdentificacionControlador {

    @Autowired
    private TipoIdentificacionServicio tipoIdentificacionServicio;

    @GetMapping
    public ResponseEntity<List<TipoIdentificacionDTO>> listarTipos() {
        return ResponseEntity.ok(tipoIdentificacionServicio.listarTodos());
    }
}

