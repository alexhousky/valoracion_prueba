package com.example.fidelidad_api.controllers;

import com.example.fidelidad_api.dtos.RegistroClienteDTO;
import com.example.fidelidad_api.models.Ciudad;
import com.example.fidelidad_api.models.Cliente;
import com.example.fidelidad_api.models.TipoIdentificacion;
import com.example.fidelidad_api.services.CiudadServicio;
import com.example.fidelidad_api.services.ClienteServicio;
import com.example.fidelidad_api.services.TipoIdentificacionServicio;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clientes")
@CrossOrigin(origins = "*")
public class ClienteControlador {

    @Autowired
    private ClienteServicio clienteServicio;

    @Autowired
    private TipoIdentificacionServicio tipoIdentificacionServicio;

    @Autowired
    private CiudadServicio ciudadServicio;

    // ✅ GET base para listar todos los clientes con manejo de errores
    @GetMapping
    public ResponseEntity<?> listarClientes() {
        try {
            List<Cliente> clientes = clienteServicio.obtenerTodosLosClientes();
            return ResponseEntity.ok(clientes);
        } catch (Exception e) {
            e.printStackTrace(); // 🔍 Esto muestra la causa real en la consola
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error al listar clientes: " + e.getMessage());
        }
    }

    @PostMapping
    public ResponseEntity<?> crearCliente(@Valid @RequestBody RegistroClienteDTO dto) {
        try {
            TipoIdentificacion tipoIdentificacion = tipoIdentificacionServicio.obtenerPorId(dto.getTipoIdentificacionId());
            Ciudad ciudad = ciudadServicio.obtenerPorId(dto.getCiudadId());

            Cliente cliente = new Cliente();
            cliente.setTipoIdentificacion(tipoIdentificacion);
            cliente.setNumeroIdentificacion(dto.getNumeroIdentificacion());
            cliente.setNombres(dto.getNombres());
            cliente.setApellidos(dto.getApellidos());
            cliente.setFechaNacimiento(dto.getFechaNacimiento());
            cliente.setDireccion(dto.getDireccion());
            cliente.setCiudad(ciudad);

            Cliente guardado = clienteServicio.guardarCliente(cliente);
            return ResponseEntity.ok(guardado);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error al crear cliente: " + e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> obtenerCliente(@PathVariable Long id) {
        try {
            Cliente cliente = clienteServicio.obtenerClientePorId(id);
            return (cliente != null) ? ResponseEntity.ok(cliente) : ResponseEntity.notFound().build();
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error al obtener cliente: " + e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarCliente(@PathVariable Long id) {
        try {
            clienteServicio.eliminarCliente(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error al eliminar cliente: " + e.getMessage());
        }
    }
}

