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
    public List<TipoIdentificacion> getAll() {
        return tipoIdentificacionRepository.findAll();
    }

    @Override
    public TipoIdentificacion getById(Long id) {  // ✅ Aquí lo implementamos
        Optional<TipoIdentificacion> result = tipoIdentificacionRepository.findById(id);
        return result.orElse(null);
    }

    @Override
    public TipoIdentificacion create(TipoIdentificacion tipoIdentificacion) {
        return tipoIdentificacionRepository.save(tipoIdentificacion);
    }

    @Override
    public TipoIdentificacion update(TipoIdentificacion tipoIdentificacion) {
        return tipoIdentificacionRepository.save(tipoIdentificacion);
    }

    @Override
    public void delete(Long id) {
        tipoIdentificacionRepository.deleteById(id);
    }
}

