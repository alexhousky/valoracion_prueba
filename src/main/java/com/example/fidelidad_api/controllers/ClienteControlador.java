package com.example.fidelidad_api.controllers;

import com.example.fidelidad_api.models.Cliente;
import com.example.fidelidad_api.services.ClienteServicio;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clientes")
@CrossOrigin(origins = "*")
public class ClienteControlador {
    private final ClienteServicio clienteServicio;

    public ClienteControlador(ClienteServicio clienteServicio) {
        this.clienteServicio = clienteServicio;
    }

    @PostMapping
    public Cliente registrar(@RequestBody Cliente cliente) {
        return clienteServicio.guardar(cliente);
    }

    @GetMapping
    public List<Cliente> listar() {
        return clienteServicio.listarClientes();
    }

    @GetMapping("/{id}")
    public Cliente obtener(@PathVariable Integer id) {
        return clienteServicio.buscarPorId(id);
    }
}
