package com.example.fidelidad_api.service.impl;

import com.example.fidelidad_api.entity.TipoIdentificacion;
import com.example.fidelidad_api.repository.TipoIdentificacionRepository;
import com.example.fidelidad_api.service.TipoIdentificacionService;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class TipoIdentificacionServiceImpl implements TipoIdentificacionService {

    private final TipoIdentificacionRepository tipoIdentificacionRepository;

    public TipoIdentificacionServiceImpl(TipoIdentificacionRepository tipoIdentificacionRepository) {
        this.tipoIdentificacionRepository = tipoIdentificacionRepository;
    }

    @Override
    public List<TipoIdentificacion> listarTodos() {
        return tipoIdentificacionRepository.findAll();
    }
}


