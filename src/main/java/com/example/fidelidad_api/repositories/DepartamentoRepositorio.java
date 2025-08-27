package com.example.fidelidad_api.repositories;

import com.example.fidelidad_api.models.Departamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DepartamentoRepositorio extends JpaRepository<Departamento, Long> {
    List<Departamento> findByPaisId(Long paisId);
}
