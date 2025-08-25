package com.example.fidelidad_api.service;

import com.example.fidelidad_api.entity.Marca;

import java.util.List;
import java.util.Optional;

public interface MarcaService {

    List<Marca> findAll();

    Optional<Marca> findById(Long id);

    Marca save(Marca marca);

    void deleteById(Long id);
}
