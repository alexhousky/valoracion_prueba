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
    public ResponseEntity<List<Marca>> listar() {
        return ResponseEntity.ok(marcaService.listarMarcas());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Marca> obtenerPorId(@PathVariable Long id) {
        return marcaService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Marca> crear(@RequestBody Marca marca) {
        return ResponseEntity.ok(marcaService.crearMarca(marca));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Marca> actualizar(@PathVariable Long id, @RequestBody Marca marca) {
        return ResponseEntity.ok(marcaService.actualizarMarca(id, marca));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        marcaService.eliminarMarca(id);
        return ResponseEntity.noContent().build();
    }
}
