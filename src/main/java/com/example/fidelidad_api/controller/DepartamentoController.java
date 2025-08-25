package com.example.fidelidad_api.controller;

import com.example.fidelidad_api.entity.Departamento;
import com.example.fidelidad_api.service.DepartamentoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/departamentos")
@CrossOrigin(origins = "*")
public class DepartamentoController {

    private final DepartamentoService departamentoService;

    public DepartamentoController(DepartamentoService departamentoService) {
        this.departamentoService = departamentoService;
    }

    @PostMapping
    public ResponseEntity<Departamento> guardar(@RequestBody Departamento departamento) {
        Departamento nuevo = departamentoService.guardar(departamento);
        return ResponseEntity.ok(nuevo);
    }

    @GetMapping
    public ResponseEntity<List<Departamento>> listarTodos() {
        return ResponseEntity.ok(departamentoService.listarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Departamento> obtenerPorId(@PathVariable Long id) {
        Departamento departamento = departamentoService.obtenerPorId(id);
        if (departamento != null) {
            return ResponseEntity.ok(departamento);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        departamentoService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
