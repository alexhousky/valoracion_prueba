package com.example.fidelidad_api.repositories;

import com.example.fidelidad_api.models.Ciudad;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CiudadRepositorio extends JpaRepository<Ciudad, Integer> {
}
