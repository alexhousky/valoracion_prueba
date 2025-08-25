package com.example.fidelidad_api.controller;

import com.example.fidelidad_api.entity.Fidelizacion;
import com.example.fidelidad_api.service.FidelizacionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/fidelizacion")
public class FidelizacionController {

    private final FidelizacionService fidelizacionService;

    public FidelizacionController(FidelizacionService fidelizacionService) {
        this.fidelizacionService = fidelizacionService;
    }

    // Listar todos
    @GetMapping
    public List<Fidelizacion> getAll() {
        return fidelizacionService.findAll();
    }

    // Consultar por ID
    @GetMapping("/{id}")
    public ResponseEntity<Fidelizacion> getById(@PathVariable Long id) {
        return fidelizacionService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Crear inscripción
    @PostMapping
    public Fidelizacion create(@RequestBody Fidelizacion fidelizacion) {
        return fidelizacionService.save(fidelizacion);
    }

    // Actualizar inscripción
    @PutMapping("/{id}")
    public ResponseEntity<Fidelizacion> update(@PathVariable Long id, @RequestBody Fidelizacion fidelizacion) {
        return fidelizacionService.findById(id)
                .map(existing -> {
                    existing.setCliente(fidelizacion.getCliente());
                    existing.setMarca(fidelizacion.getMarca());
                    existing.setEstado(fidelizacion.getEstado());
                    return ResponseEntity.ok(fidelizacionService.save(existing));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    // Eliminar inscripción
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (fidelizacionService.findById(id).isPresent()) {
            fidelizacionService.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
