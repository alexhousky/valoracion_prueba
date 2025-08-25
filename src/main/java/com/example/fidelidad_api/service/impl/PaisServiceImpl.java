package com.example.fidelidad_api.service.impl;

import com.example.fidelidad_api.entity.Pais;
import com.example.fidelidad_api.repository.PaisRepository;
import com.example.fidelidad_api.service.PaisService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PaisServiceImpl implements PaisService {

    private final PaisRepository paisRepository;

    public PaisServiceImpl(PaisRepository paisRepository) {
        this.paisRepository = paisRepository;
    }

    @Override
    public Pais guardar(Pais pais) {
        return paisRepository.save(pais);
    }

    @Override
    public List<Pais> listarTodos() {
        return paisRepository.findAll();
    }

    @Override
    public Pais obtenerPorId(Long id) {
        Optional<Pais> pais = paisRepository.findById(id);
        return pais.orElse(null);
    }

    @Override
    public void eliminar(Long id) {
        paisRepository.deleteById(id);
    }
}
