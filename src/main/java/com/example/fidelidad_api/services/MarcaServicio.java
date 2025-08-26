package com.example.fidelidad_api.services;

import com.example.fidelidad_api.models.Marca;
import com.example.fidelidad_api.repositories.MarcaRepositorio;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MarcaServicio {
    private final MarcaRepositorio marcaRepositorio;

    public MarcaServicio(MarcaRepositorio marcaRepository) {
        this.marcaRepositorio = marcaRepository;
    }

    public List<Marca> listarMarcas() {
        return marcaRepositorio.findAll();
    }

    public Marca buscarPorId(Integer id) {
        return marcaRepositorio.findById(id).orElse(null);
    }
}
