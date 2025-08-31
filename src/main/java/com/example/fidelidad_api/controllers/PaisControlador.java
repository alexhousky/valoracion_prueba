package com.example.fidelidad_api.controllers;

import com.example.fidelidad_api.dtos.PaisDTO;
import com.example.fidelidad_api.services.PaisServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/paises")
public class PaisControlador {

    @Autowired
    private PaisServicio paisServicio;

    @GetMapping
    public ResponseEntity<List<PaisDTO>> listarPaises() {
        return ResponseEntity.ok(paisServicio.listarTodos());
    }
}
