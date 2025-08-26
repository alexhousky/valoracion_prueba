package com.example.fidelidad_api.repositories;

import com.example.fidelidad_api.models.Marca;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MarcaRepositorio extends JpaRepository<Marca, Integer> {
}
