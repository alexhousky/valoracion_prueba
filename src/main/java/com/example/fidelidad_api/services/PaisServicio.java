package com.example.fidelidad_api.services;

import com.example.fidelidad_api.models.Pais;
import com.example.fidelidad_api.repositories.PaisRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaisServicio {

    @Autowired
    private PaisRepositorio paisRepositorio;

    public List<Pais> listarTodos() {
        return paisRepositorio.findAll();
    }
}
