package com.example.fidelidad_api.service.impl;

import com.example.fidelidad_api.entity.Cliente;
import com.example.fidelidad_api.repository.ClienteRepository;
import com.example.fidelidad_api.service.ClienteService;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ClienteServiceImpl implements ClienteService {

    private final ClienteRepository clienteRepository;

    public ClienteServiceImpl(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    @Override
    public Cliente guardarCliente(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    @Override
    public List<Cliente> listarClientes() {
        return clienteRepository.findAll();
    }
}
