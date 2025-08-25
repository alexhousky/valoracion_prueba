package com.example.fidelidad_api.service.impl;

import com.example.fidelidad_api.entity.Pais;
import com.example.fidelidad_api.repository.PaisRepository;
import com.example.fidelidad_api.service.PaisService;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PaisServiceImpl implements PaisService {

    private final PaisRepository paisRepository;

    public PaisServiceImpl(PaisRepository paisRepository) {
        this.paisRepository = paisRepository;
    }

    @Override
    public List<Pais> listarTodos() {
        return paisRepository.findAll();
    }
}
