package com.example.fidelidad_api.service.impl;

import com.example.fidelidad_api.entity.TipoIdentificacion;
import com.example.fidelidad_api.repository.TipoIdentificacionRepository;
import com.example.fidelidad_api.service.TipoIdentificacionService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TipoIdentificacionServiceImpl implements TipoIdentificacionService {

    private final TipoIdentificacionRepository tipoIdentificacionRepository;

    public TipoIdentificacionServiceImpl(TipoIdentificacionRepository tipoIdentificacionRepository) {
        this.tipoIdentificacionRepository = tipoIdentificacionRepository;
    }

    @Override
    public List<TipoIdentificacion> findAll() {
        return tipoIdentificacionRepository.findAll();
    }

    @Override
    public Optional<TipoIdentificacion> findById(Long id) {
        return tipoIdentificacionRepository.findById(id);
    }

    @Override
    public TipoIdentificacion save(TipoIdentificacion tipoIdentificacion) {
        return tipoIdentificacionRepository.save(tipoIdentificacion);
    }

    @Override
    public void deleteById(Long id) {
        tipoIdentificacionRepository.deleteById(id);
    }
}
