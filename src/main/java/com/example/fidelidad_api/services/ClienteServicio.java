package com.example.fidelidad_api.services;

import com.example.fidelidad_api.dtos.ClienteDTO;
import com.example.fidelidad_api.models.Cliente;
import com.example.fidelidad_api.repositories.ClienteRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteServicio {

    @Autowired
    private ClienteRepositorio clienteRepositorio;

    // Listar como entidad (si lo requieres internamente)
    public List<Cliente> obtenerTodosLosClientes() {
        return clienteRepositorio.findAll();
    }

    // Listar como DTO para API
    public List<ClienteDTO> obtenerClientesDTO() {
        List<Cliente> clientes = clienteRepositorio.findAll();
        return clientes.stream()
                .map(c -> new ClienteDTO(
                        c.getId(),
                        c.getNumeroIdentificacion(),
                        c.getNombres(),
                        c.getApellidos(),
                        c.getTipoIdentificacion() != null ? c.getTipoIdentificacion().getNombre() : null,
                        c.getCiudad() != null ? c.getCiudad().getNombre() : null
                ))
                .toList();
    }

    public Cliente guardarCliente(Cliente cliente) {
        return clienteRepositorio.save(cliente);
    }

    public ClienteDTO guardarClienteYRetornarDTO(Cliente cliente) {
        Cliente guardado = clienteRepositorio.save(cliente);
        return new ClienteDTO(
                guardado.getId(),
                guardado.getNumeroIdentificacion(),
                guardado.getNombres(),
                guardado.getApellidos(),
                guardado.getTipoIdentificacion() != null ? guardado.getTipoIdentificacion().getNombre() : null,
                guardado.getCiudad() != null ? guardado.getCiudad().getNombre() : null
        );
    }

    public Cliente obtenerClientePorId(Long id) {
        return clienteRepositorio.findById(id).orElse(null);
    }

    public void eliminarCliente(Long id) {
        clienteRepositorio.deleteById(id);
    }
}