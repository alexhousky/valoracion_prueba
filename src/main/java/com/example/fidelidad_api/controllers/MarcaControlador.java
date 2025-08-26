package com.example.fidelidad_api.controllers;

import com.example.fidelidad_api.models.Marca;
import com.example.fidelidad_api.services.MarcaServicio;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/marcas")
@CrossOrigin(origins = "*")
public class MarcaControlador {
    private final MarcaServicio marcaServicio;

    public MarcaControlador(MarcaServicio marcaServicio) {
        this.marcaServicio = marcaServicio;
    }

    @GetMapping
    public List<Marca> listar() {
        return marcaServicio.listarMarcas();
    }

    @GetMapping("/{id}")
    public Marca obtener(@PathVariable Integer id) {
        return marcaServicio.buscarPorId(id);
    }
}

