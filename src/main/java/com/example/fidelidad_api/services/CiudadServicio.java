package com.example.fidelidad_api.services;

import com.example.fidelidad_api.models.Ciudad;
import com.example.fidelidad_api.repositories.CiudadRepositorio;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CiudadServicio {
    private final CiudadRepositorio ciudadRepositorio;

    public CiudadServicio(CiudadRepositorio ciudadRepositorio) {
        this.ciudadRepositorio = ciudadRepositorio;
    }

    public List<Ciudad> listarCiudades() {
        return ciudadRepositorio.findAll();
    }

    public Ciudad buscarPorId(Integer id) {
        return ciudadRepositorio.findById(id).orElse(null);
    }
}
