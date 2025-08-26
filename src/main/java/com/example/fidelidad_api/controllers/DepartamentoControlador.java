package com.example.fidelidad_api.controllers;

import com.example.fidelidad_api.models.Departamento;
import com.example.fidelidad_api.services.DepartamentoServicio;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/departamentos")
@CrossOrigin(origins = "*")
public class DepartamentoControlador {
    private final DepartamentoServicio departamentoServicio;

    public DepartamentoControlador(DepartamentoServicio departamentoServicio) {
        this.departamentoServicio= departamentoServicio;
    }

    @GetMapping
    public List<Departamento> listar() {
        return departamentoServicio.listarDepartamentos();
    }

    @GetMapping("/{id}")
    public Departamento obtener(@PathVariable Integer id) {
        return departamentoServicio.buscarPorId(id);
    }
}
