package com.example.fidelidad_api.services;

import com.example.fidelidad_api.models.Pais;
import com.example.fidelidad_api.repositories.PaisRepositorio;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaisServicio {
    private final PaisRepositorio paisRepositorio;

    public PaisServicio(PaisRepositorio paisRepositorio) {
        this.paisRepositorio = paisRepositorio;
    }

    public List<Pais> listarPaises() {
        return paisRepositorio.findAll();
    }

    public Pais buscarPorId(Integer id) {
        return paisRepositorio.findById(id).orElse(null);
    }
}
