package com.example.fidelidad_api.repository;

import com.example.fidelidad_api.entity.TipoIdentificacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoIdentificacionRepository extends JpaRepository<TipoIdentificacion, Long> {
}
