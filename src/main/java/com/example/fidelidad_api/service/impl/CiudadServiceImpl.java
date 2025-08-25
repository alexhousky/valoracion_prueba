package com.example.fidelidad_api.service.impl;

import com.example.fidelidad_api.entity.Ciudad;
import com.example.fidelidad_api.repository.CiudadRepository;
import com.example.fidelidad_api.service.CiudadService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CiudadServiceImpl implements CiudadService {

    private final CiudadRepository ciudadRepository;

    public CiudadServiceImpl(CiudadRepository ciudadRepository) {
        this.ciudadRepository = ciudadRepository;
    }

    @Override
    public Ciudad guardar(Ciudad ciudad) {
        return ciudadRepository.save(ciudad);
    }

    @Override
    public List<Ciudad> listarTodas() {
        return ciudadRepository.findAll();
    }

    @Override
    public Ciudad obtenerPorId(Long id) {
        Optional<Ciudad> ciudad = ciudadRepository.findById(id);
        return ciudad.orElse(null);
    }

    @Override
    public void eliminar(Long id) {
        ciudadRepository.deleteById(id);
    }
}

