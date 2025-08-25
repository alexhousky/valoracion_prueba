package com.example.fidelidad_api.controller;

import com.example.fidelidad_api.entity.Pais;
import com.example.fidelidad_api.service.PaisService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/paises")
@CrossOrigin(origins = "*")
public class PaisController {

    private final PaisService paisService;

    public PaisController(PaisService paisService) {
        this.paisService = paisService;
    }

    @PostMapping
    public ResponseEntity<Pais> guardar(@RequestBody Pais pais) {
        Pais nuevo = paisService.guardar(pais);
        return ResponseEntity.ok(nuevo);
    }

    @GetMapping
    public ResponseEntity<List<Pais>> listarTodos() {
        return ResponseEntity.ok(paisService.listarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pais> obtenerPorId(@PathVariable Long id) {
        Pais pais = paisService.obtenerPorId(id);
        if (pais != null) {
            return ResponseEntity.ok(pais);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        paisService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
