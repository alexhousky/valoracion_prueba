package com.example.fidelidad_api.controllers;

import com.example.fidelidad_api.models.Departamento;
import com.example.fidelidad_api.services.DepartamentoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/departamentos")
public class DepartamentoControlador {

    @Autowired
    private DepartamentoServicio departamentoServicio;

    // ✅ Endpoint para listar TODOS los departamentos
    @GetMapping
    public List<Departamento> listarTodos() {
        return departamentoServicio.listarTodos();
    }

    // ✅ Endpoint para listar por país
    @GetMapping("/pais/{paisId}")
    public List<Departamento> listarPorPais(@PathVariable Long paisId) {
        return departamentoServicio.listarPorPais(paisId);
    }
}


