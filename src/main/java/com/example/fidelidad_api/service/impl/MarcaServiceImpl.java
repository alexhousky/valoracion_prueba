package com.example.fidelidad_api.service.impl;

import com.example.fidelidad_api.entity.Marca;
import com.example.fidelidad_api.repository.MarcaRepository;
import com.example.fidelidad_api.service.MarcaService;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class MarcaServiceImpl implements MarcaService {

    private final MarcaRepository marcaRepository;

    public MarcaServiceImpl(MarcaRepository marcaRepository) {
        this.marcaRepository = marcaRepository;
    }

    @Override
    public List<Marca> listarTodas() {
        return marcaRepository.findAll();
    }
}

