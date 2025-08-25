package com.example.fidelidad_api.service;

import com.example.fidelidad_api.entity.Fidelizacion;
import java.util.List;

public interface FidelizacionService {
    Fidelizacion guardar(Fidelizacion fidelizacion);
    List<Fidelizacion> listarTodas();
}

