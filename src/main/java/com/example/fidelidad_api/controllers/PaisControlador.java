package com.example.fidelidad_api.controllers;

import com.example.fidelidad_api.models.Pais;
import com.example.fidelidad_api.services.PaisServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/paises")
public class PaisControlador {

    @Autowired
    private PaisServicio paisServicio;

    @GetMapping
    public List<Pais> listarPaises() {
        return paisServicio.listarTodos();
    }
}
