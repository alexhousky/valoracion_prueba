package com.example.fidelidad_api.controller;

import com.example.fidelidad_api.entity.TipoIdentificacion;
import com.example.fidelidad_api.service.TipoIdentificacionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tipo-identificacion")
public class TipoIdentificacionController {

    private final TipoIdentificacionService tipoIdentificacionService;

    public TipoIdentificacionController(TipoIdentificacionService tipoIdentificacionService) {
        this.tipoIdentificacionService = tipoIdentificacionService;
    }

    @GetMapping
    public List<TipoIdentificacion> getAll() {
        return tipoIdentificacionService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<TipoIdentificacion> getById(@PathVariable Long id) {
        return tipoIdentificacionService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Opción: si quieres mantener el catálogo fijo, puedes deshabilitar POST/PUT/DELETE
    @PostMapping
    public TipoIdentificacion create(@RequestBody TipoIdentificacion tipoIdentificacion) {
        return tipoIdentificacionService.save(tipoIdentificacion);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TipoIdentificacion> update(@PathVariable Long id, @RequestBody TipoIdentificacion tipoIdentificacion) {
        return tipoIdentificacionService.findById(id)
                .map(existing -> {
                    existing.setNombre(tipoIdentificacion.getNombre());
                    return ResponseEntity.ok(tipoIdentificacionService.save(existing));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (tipoIdentificacionService.findById(id).isPresent()) {
            tipoIdentificacionService.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
