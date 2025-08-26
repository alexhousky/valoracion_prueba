package com.example.fidelidad_api.services;

import com.example.fidelidad_api.models.Departamento;
import com.example.fidelidad_api.repositories.DepartamentoRepositorio;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartamentoServicio {
    private final DepartamentoRepositorio departamentoRepositorio;

    public DepartamentoServicio(DepartamentoRepositorio departamentoRepositorio) {
        this.departamentoRepositorio = departamentoRepositorio;
    }

    public List<Departamento> listarDepartamentos() {
        return departamentoRepositorio.findAll();
    }

    public Departamento buscarPorId(Integer id) {
        return departamentoRepositorio.findById(id).orElse(null);
    }
}
