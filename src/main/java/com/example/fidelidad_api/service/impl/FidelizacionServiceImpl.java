package com.example.fidelidad_api.service.impl;

import com.example.fidelidad_api.entity.Fidelizacion;
import com.example.fidelidad_api.repository.FidelizacionRepository;
import com.example.fidelidad_api.service.FidelizacionService;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class FidelizacionServiceImpl implements FidelizacionService {

    private final FidelizacionRepository fidelizacionRepository;

    public FidelizacionServiceImpl(FidelizacionRepository fidelizacionRepository) {
        this.fidelizacionRepository = fidelizacionRepository;
    }

    @Override
    public Fidelizacion guardar(Fidelizacion fidelizacion) {
        return fidelizacionRepository.save(fidelizacion);
    }

    @Override
    public List<Fidelizacion> listarTodas() {
        return fidelizacionRepository.findAll();
    }
}

