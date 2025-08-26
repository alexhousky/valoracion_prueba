package com.example.fidelidad_api.controllers;

import com.example.fidelidad_api.models.Pais;
import com.example.fidelidad_api.services.PaisServicio;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/paises")
@CrossOrigin(origins = "*")
public class PaisControlador {
    private final PaisServicio paisServicio;

    public PaisControlador(PaisServicio paisServicio) {
        this.paisServicio = paisServicio;
    }

    @GetMapping
    public List<Pais> listar() {
        return paisServicio.listarPaises();
    }

    @GetMapping("/{id}")
    public Pais obtener(@PathVariable Integer id) {
        return paisServicio.buscarPorId(id);
    }
}
