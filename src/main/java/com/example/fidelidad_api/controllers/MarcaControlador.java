package com.example.fidelidad_api.controllers;

import com.example.fidelidad_api.models.Marca;
import com.example.fidelidad_api.services.MarcaServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/marcas")
public class MarcaControlador {

    @Autowired
    private MarcaServicio marcaServicio;

    @GetMapping
    public List<Marca> listarMarcas() {
        return marcaServicio.obtenerTodasLasMarcas();
    }
}
