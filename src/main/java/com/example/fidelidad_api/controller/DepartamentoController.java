package com.example.fidelidad_api.controller;

import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/departamentos")
public class DepartamentoController {

    private final DepartamentoService departamentoService;

    public DepartamentoController(DepartamentoService departamentoService) {
        this.departamentoService = departamentoService;
    }

    @GetMapping("/listar")
    public List<Departamento> listarDepartamentos(@RequestParam(required = false) Integer paisId) {
        if(paisId != null) {
            return departamentoService.listarPorPais(paisId);
        }
        return departamentoService.listarTodos();
    }
}
