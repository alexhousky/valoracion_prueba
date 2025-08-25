package com.example.fidelidad_api.controller;

import com.example.fidelidad_api.entity.Marca;
import com.example.fidelidad_api.service.MarcaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/marcas")
public class MarcaController {

    private final MarcaService marcaService;

    public MarcaController(MarcaService marcaService) {
        this.marcaService = marcaService;
    }

    @GetMapping
    public List<Marca> getAll() {
        return marcaService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Marca> getById(@PathVariable Long id) {
        return marcaService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Si quieres dejar CRUD abierto:
    @PostMapping
    public Marca create(@RequestBody Marca marca) {
        return marcaService.save(marca);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Marca> update(@PathVariable Long id, @RequestBody Marca marca) {
        return marcaService.findById(id)
                .map(existing -> {
                    existing.setNombre(marca.getNombre());
                    return ResponseEntity.ok(marcaService.save(existing));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (marcaService.findById(id).isPresent()) {
            marcaService.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
