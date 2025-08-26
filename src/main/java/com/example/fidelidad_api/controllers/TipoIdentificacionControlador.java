package com.example.fidelidad_api.controllers;

import com.example.fidelidad_api.models.TipoIdentificacion;
import com.example.fidelidad_api.services.TipoIdentificacionServicio;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tipos-identificacion")
@CrossOrigin(origins = "*")
public class TipoIdentificacionControlador {
    private final TipoIdentificacionServicio tipoIdentificacionServicio;

    public TipoIdentificacionControlador(TipoIdentificacionServicio tipoIdentificacionServicio) {
        this.tipoIdentificacionServicio = tipoIdentificacionServicio;
    }

    @GetMapping
    public List<TipoIdentificacion> listar() {
        return tipoIdentificacionServicio.listarTipos();
    }

    @GetMapping("/{id}")
    public TipoIdentificacion obtener(@PathVariable Integer id) {
        return tipoIdentificacionServicio.buscarPorId(id);
    }
}
