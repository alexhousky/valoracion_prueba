package com.example.fidelidad_api.controllers;

import com.example.fidelidad_api.models.TipoIdentificacion;
import com.example.fidelidad_api.services.TipoIdentificacionServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tipo-identificacion")
public class TipoIdentificacionControlador {

    @Autowired
    private TipoIdentificacionServicio tipoIdentificacionServicio;

    @GetMapping
    public List<TipoIdentificacion> listarTipos() {
        return tipoIdentificacionServicio.listarTodos();
    }
}