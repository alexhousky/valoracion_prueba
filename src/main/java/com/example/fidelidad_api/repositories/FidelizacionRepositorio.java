package com.example.fidelidad_api.repositories;

import com.example.fidelidad_api.models.Fidelizacion;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FidelizacionRepositorio extends JpaRepository<Fidelizacion, Integer> {

    // Listar fidelizaciones por id de cliente (columna clientes.id_clientes)
    List<Fidelizacion> findByCliente_IdClientes(Integer idClientes);

    // Listar fidelizaciones por id de marca (columna marcas.id_marcas)
    List<Fidelizacion> findByMarca_IdMarcas(Integer idMarcas);

    // Verificar duplicados (un mismo cliente en una misma marca)
    boolean existsByCliente_IdClientesAndMarca_IdMarcas(Integer idClientes, Integer idMarcas);
}
