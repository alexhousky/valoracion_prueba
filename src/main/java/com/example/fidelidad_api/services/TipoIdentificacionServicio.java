package com.example.fidelidad_api.services;

import com.example.fidelidad_api.models.TipoIdentificacion;
import com.example.fidelidad_api.dtos.TipoIdentificacionDTO;
import com.example.fidelidad_api.repositories.TipoIdentificacionRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.stream.Collectors;
import java.util.List;



import java.util.Optional;

@Service
public class TipoIdentificacionServicio {

    @Autowired
    private TipoIdentificacionRepositorio tipoIdentificacionRepositorio;

    public TipoIdentificacion obtenerPorId(Long id) {
        Optional<TipoIdentificacion> tipo = tipoIdentificacionRepositorio.findById(id);
        return tipo.orElseThrow(() -> new RuntimeException("TipoIdentificacion no encontrado con id: " + id));
    }

    public List<TipoIdentificacionDTO> listarTodos() {
        return tipoIdentificacionRepositorio.findAll().stream()
                .map(t -> new TipoIdentificacionDTO(t.getId(), t.getNombre()))
                .collect(Collectors.toList());
    }
}




