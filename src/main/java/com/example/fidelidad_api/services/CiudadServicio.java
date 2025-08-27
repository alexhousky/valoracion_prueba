package com.example.fidelidad_api.services;

import com.example.fidelidad_api.models.Ciudad;
import com.example.fidelidad_api.repositories.CiudadRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CiudadServicio {

    @Autowired
    private CiudadRepositorio ciudadRepositorio;

    public List<Ciudad> listarTodas() {
        return ciudadRepositorio.findAll();
    }

    public Ciudad obtenerPorId(Long id) {
        return ciudadRepositorio.findById(id).orElse(null);
    }

    public List<Ciudad> listarPorDepartamento(Long departamentoId) {
        return ciudadRepositorio.findByDepartamentoId(departamentoId);
    }
}



