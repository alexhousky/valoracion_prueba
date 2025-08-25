package com.example.fidelidad_api.controller;

import com.example.fidelidad_api.entity.Ciudad;
import com.example.fidelidad_api.service.CiudadService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ciudades")
@CrossOrigin(origins = "*")
public class CiudadController {

    private final CiudadService ciudadService;

    public CiudadController(CiudadService ciudadService) {
        this.ciudadService = ciudadService;
    }

    @PostMapping
    public ResponseEntity<Ciudad> guardar(@RequestBody Ciudad ciudad) {
        Ciudad nuevaCiudad = ciudadService.guardar(ciudad);
        return ResponseEntity.ok(nuevaCiudad);
    }

    @GetMapping
    public ResponseEntity<List<Ciudad>> listarTodas() {
        return ResponseEntity.ok(ciudadService.listarTodas());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Ciudad> obtenerPorId(@PathVariable Long id) {
        Ciudad ciudad = ciudadService.obtenerPorId(id);
        if (ciudad != null) {
            return ResponseEntity.ok(ciudad);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        ciudadService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
    
