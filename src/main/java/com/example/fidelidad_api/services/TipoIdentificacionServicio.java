package com.example.fidelidad_api.services;

import com.example.fidelidad_api.models.TipoIdentificacion;
import com.example.fidelidad_api.repositories.TipoIdentificacionRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TipoIdentificacionServicio {

    @Autowired
    private TipoIdentificacionRepositorio tipoIdentificacionRepositorio;

    public List<TipoIdentificacion> listarTodos() {
        return tipoIdentificacionRepositorio.findAll();
    }

    public TipoIdentificacion obtenerPorId(Long id) {
        return tipoIdentificacionRepositorio.findById(id).orElse(null);
    }
}



