package com.example.fidelidad_api.service.impl;

import com.example.fidelidad_api.entity.Ciudad;
import com.example.fidelidad_api.repository.CiudadRepository;
import com.example.fidelidad_api.service.CiudadService;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CiudadServiceImpl implements CiudadService {

    private final CiudadRepository ciudadRepository;

    public CiudadServiceImpl(CiudadRepository ciudadRepository) {
        this.ciudadRepository = ciudadRepository;
    }

    @Override
    public List<Ciudad> listarTodas() {
        return ciudadRepository.findAll();
    }
}
