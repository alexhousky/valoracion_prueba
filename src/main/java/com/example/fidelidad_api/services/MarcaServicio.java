package com.example.fidelidad_api.services;

import com.example.fidelidad_api.models.Marca;
import com.example.fidelidad_api.repositories.MarcaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MarcaServicio {

    @Autowired
    private MarcaRepositorio marcaRepo;

    public List<Marca> obtenerTodasLasMarcas() {
        return marcaRepo.findAll();
    }
}