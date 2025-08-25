package com.example.fidelidad_api.service;

import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class TipoIdentificacionService {

    private final TipoIdentificacionRepository tipoIdentificacionRepository;

    public TipoIdentificacionService(TipoIdentificacionRepository tipoIdentificacionRepository) {
        this.tipoIdentificacionRepository = tipoIdentificacionRepository;
    }

    public List<TipoIdentificacion> listarTipos() {
        return tipoIdentificacionRepository.findAll();
    }
}


