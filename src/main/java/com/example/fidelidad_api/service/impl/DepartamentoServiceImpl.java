package com.example.fidelidad_api.service.impl;

import com.example.fidelidad_api.entity.Departamento;
import com.example.fidelidad_api.repository.DepartamentoRepository;
import com.example.fidelidad_api.service.DepartamentoService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DepartamentoServiceImpl implements DepartamentoService {

    private final DepartamentoRepository departamentoRepository;

    public DepartamentoServiceImpl(DepartamentoRepository departamentoRepository) {
        this.departamentoRepository = departamentoRepository;
    }

    @Override
    public Departamento guardar(Departamento departamento) {
        return departamentoRepository.save(departamento);
    }

    @Override
    public List<Departamento> listarTodos() {
        return departamentoRepository.findAll();
    }

    @Override
    public Departamento obtenerPorId(Long id) {
        Optional<Departamento> departamento = departamentoRepository.findById(id);
        return departamento.orElse(null);
    }

    @Override
    public void eliminar(Long id) {
        departamentoRepository.deleteById(id);
    }
}
