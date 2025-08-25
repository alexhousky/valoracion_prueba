package com.example.fidelidad_api.service.impl;

import com.example.fidelidad_api.entity.Marca;
import com.example.fidelidad_api.repository.MarcaRepository;
import com.example.fidelidad_api.service.MarcaService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MarcaServiceImpl implements MarcaService {

    private final MarcaRepository marcaRepository;

    public MarcaServiceImpl(MarcaRepository marcaRepository) {
        this.marcaRepository = marcaRepository;
    }

    @Override
    public List<Marca> findAll() {
        return marcaRepository.findAll();
    }

    @Override
    public Optional<Marca> findById(Long id) {
        return marcaRepository.findById(id);
    }

    @Override
    public Marca save(Marca marca) {
        return marcaRepository.save(marca);
    }

    @Override
    public void deleteById(Long id) {
        marcaRepository.deleteById(id);
    }
}
