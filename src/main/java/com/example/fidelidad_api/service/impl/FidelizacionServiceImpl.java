package com.example.fidelidad_api.service.impl;

import com.example.fidelidad_api.entity.Fidelizacion;
import com.example.fidelidad_api.repository.FidelizacionRepository;
import com.example.fidelidad_api.service.FidelizacionService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FidelizacionServiceImpl implements FidelizacionService {

    private final FidelizacionRepository fidelizacionRepository;

    public FidelizacionServiceImpl(FidelizacionRepository fidelizacionRepository) {
        this.fidelizacionRepository = fidelizacionRepository;
    }

    @Override
    public List<Fidelizacion> findAll() {
        return fidelizacionRepository.findAll();
    }

    @Override
    public Optional<Fidelizacion> findById(Long id) {
        return fidelizacionRepository.findById(id);
    }

    @Override
    public Fidelizacion save(Fidelizacion fidelizacion) {
        return fidelizacionRepository.save(fidelizacion);
    }

    @Override
    public void deleteById(Long id) {
        fidelizacionRepository.deleteById(id);
    }
}
