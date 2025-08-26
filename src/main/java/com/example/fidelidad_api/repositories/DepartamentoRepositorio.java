package com.example.fidelidad_api.repositories;

import com.example.fidelidad_api.models.Departamento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartamentoRepositorio extends JpaRepository<Departamento, Integer> {
}
