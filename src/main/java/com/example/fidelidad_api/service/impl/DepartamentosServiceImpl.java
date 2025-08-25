package com.example.fidelidad_api.service.impl;

import com.example.fidelidad_api.entity.Departamento;
import com.example.fidelidad_api.repository.DepartamentoRepository;
import com.example.fidelidad_api.service.DepartamentosService;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class DepartamentosServiceImpl implements DepartamentosService {

    private final DepartamentoRepository departamentoRepository;

    public DepartamentosServiceImpl(DepartamentoRepository departamentoRepository) {
        this.departamentoRepository = departamentoRepository;
    }

    @Override
    public List<Departamento> listarTodos() {
        return departamentoRepository.findAll();
    }
}
