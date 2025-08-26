package com.example.fidelidad_api.controller;

import com.example.fidelidad_api.entity.TipoIdentificacion;
import com.example.fidelidad_api.service.TipoIdentificacionService;
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
        return tipoIdentificacionService.getAll();
    }

    @GetMapping("/{id}")
    public TipoIdentificacion getById(@PathVariable Long id) {
        return tipoIdentificacionService.getById(id);
    }

    @PostMapping
    public TipoIdentificacion create(@RequestBody TipoIdentificacion tipoIdentificacion) {
        return tipoIdentificacionService.create(tipoIdentificacion);
    }

    @PutMapping("/{id}")
    public TipoIdentificacion update(@PathVariable Long id, @RequestBody TipoIdentificacion tipoIdentificacion) {
        TipoIdentificacion existing = tipoIdentificacionService.getById(id);
        if (existing != null) {
            existing.setNombre(tipoIdentificacion.getNombre()); // ✅ aquí usamos el setter manual
            return tipoIdentificacionService.update(existing);
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        tipoIdentificacionService.delete(id);
    }
}

