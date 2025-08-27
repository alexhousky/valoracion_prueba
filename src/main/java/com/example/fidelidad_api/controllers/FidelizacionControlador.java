// src/main/java/com/example/fidelidad_api/controllers/FidelizacionControlador.java
package com.example.fidelidad_api.controllers;

import com.example.fidelidad_api.dtos.ActualizarEstadoFidelizacionDTO;
import com.example.fidelidad_api.dtos.CrearFidelizacionDTO;
import com.example.fidelidad_api.dtos.FidelizacionDTO;
import com.example.fidelidad_api.services.FidelizacionServicio;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/fidelizacion")
public class FidelizacionControlador {

    private final FidelizacionServicio fidelizacionServicio;

    public FidelizacionControlador(FidelizacionServicio fidelizacionServicio) {
        this.fidelizacionServicio = fidelizacionServicio;
    }

    @PostMapping
    public ResponseEntity<FidelizacionDTO> crear(@Valid @RequestBody CrearFidelizacionDTO request) {
        FidelizacionDTO creado = fidelizacionServicio.crear(request);
        return ResponseEntity.created(URI.create("/api/fidelizacion/" + creado.getId())).body(creado);
    }

    @GetMapping("/{id}")
    public ResponseEntity<FidelizacionDTO> obtener(@PathVariable Integer id) {
        return ResponseEntity.ok(fidelizacionServicio.obtener(id));
    }

    @GetMapping("/cliente/{clienteId}")
    public ResponseEntity<List<FidelizacionDTO>> listarPorCliente(@PathVariable Integer clienteId) {
        return ResponseEntity.ok(fidelizacionServicio.listarPorCliente(clienteId));
    }

    @GetMapping("/marca/{marcaId}")
    public ResponseEntity<List<FidelizacionDTO>> listarPorMarca(@PathVariable Integer marcaId) {
        return ResponseEntity.ok(fidelizacionServicio.listarPorMarca(marcaId));
    }

    @GetMapping("/buscar")
    public ResponseEntity<FidelizacionDTO> obtenerPorClienteYMarca(@RequestParam Integer clienteId,
                                                                   @RequestParam Integer marcaId) {
        return ResponseEntity.ok(fidelizacionServicio.obtenerPorClienteYMarca(clienteId, marcaId));
    }

    @PutMapping("/{id}/estado")
    public ResponseEntity<FidelizacionDTO> actualizarEstado(@PathVariable Integer id,
                                                            @Valid @RequestBody ActualizarEstadoFidelizacionDTO request) {
        return ResponseEntity.ok(fidelizacionServicio.actualizarEstado(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
        fidelizacionServicio.eliminar(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
