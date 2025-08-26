package com.example.fidelidad_api.services;

import com.example.fidelidad_api.models.TipoIdentificacion;
import com.example.fidelidad_api.repositories.TipoIdentificacionRepositorio;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TipoIdentificacionServicio {
    private final TipoIdentificacionRepositorio tipoIdentificacionRepositorio;

    public TipoIdentificacionServicio(TipoIdentificacionRepositorio tipoIdentificacionRepositorio) {
        this.tipoIdentificacionRepositorio = tipoIdentificacionRepositorio;
    }

    public List<TipoIdentificacion> listarTipos() {
        return tipoIdentificacionRepositorio.findAll();
    }

    public TipoIdentificacion buscarPorId(Integer id) {
        return tipoIdentificacionRepositorio.findById(id).orElse(null);
    }
}
