package com.example.fidelidad_api.controllers;

import com.example.fidelidad_api.controllers.dto.FidelizacionCreateDTO;
import com.example.fidelidad_api.models.Cliente;
import com.example.fidelidad_api.models.Fidelizacion;
import com.example.fidelidad_api.models.Marca;
import com.example.fidelidad_api.repositories.ClienteRepositorio;
import com.example.fidelidad_api.repositories.FidelizacionRepositorio;
import com.example.fidelidad_api.repositories.MarcaRepositorio;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/fidelizaciones")
public class FidelizacionControlador {

    private final FidelizacionRepositorio fidelizacionRepositorio;
    private final ClienteRepositorio clienteRepositorio;
    private final MarcaRepositorio marcaRepositorio;

    public FidelizacionControlador(FidelizacionRepositorio fidelizacionRepositorio,
                                  ClienteRepositorio clienteRepositorio,
                                  MarcaRepositorio marcaRepositorio) {
        this.fidelizacionRepositorio = fidelizacionRepositorio;
        this.clienteRepositorio = clienteRepositorio;
        this.marcaRepositorio = marcaRepositorio;
    }

    // Listar todas
    @GetMapping
    public List<Fidelizacion> findAll() {
        return fidelizacionRepositorio.findAll();
    }

    // Obtener por ID
    @GetMapping("/{id}")
    public ResponseEntity<Fidelizacion> findById(@PathVariable Integer id) {
        return fidelizacionRepositorio.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Listar por cliente
    @GetMapping("/cliente/{clienteId}")
    public List<Fidelizacion> findByCliente(@PathVariable Integer clienteId) {
        return fidelizacionRepositorio.findByCliente_IdClientes(clienteId);
    }

    // Listar por marca
    @GetMapping("/marca/{marcaId}")
    public List<Fidelizacion> findByMarca(@PathVariable Integer marcaId) {
        return fidelizacionRepositorio.findByMarca_IdMarcas(marcaId);
    }

    // Crear (con DTO solo ids)
    @PostMapping
    public ResponseEntity<?> create(@RequestBody FidelizacionCreateDTO dto) {
        // Validar existencia de referencias
        Cliente cliente = clienteRepositorio.findById(dto.getClienteId())
                .orElse(null);
        if (cliente == null) {
            return ResponseEntity.badRequest().body("Cliente no encontrado: " + dto.getClienteId());
        }

        Marca marca = marcaRepositorio.findById(dto.getMarcaId())
                .orElse(null);
        if (marca == null) {
            return ResponseEntity.badRequest().body("Marca no encontrada: " + dto.getMarcaId());
        }

        // Evitar duplicados (mismo cliente + misma marca)
        boolean yaExiste = fidelizacionRepositorio
                .existsByCliente_IdClientesAndMarca_IdMarcas(dto.getClienteId(), dto.getMarcaId());
        if (yaExiste) {
            return ResponseEntity.badRequest().body("El cliente ya está fidelizado a esa marca.");
        }

        Fidelizacion f = new Fidelizacion();
        f.setCliente(cliente);
        f.setMarca(marca);

        Fidelizacion guardado = fidelizacionRepositorio.save(f);
        return ResponseEntity.created(URI.create("/api/fidelizaciones/" + guardado.getIdFidelizacion()))
                .body(guardado);
    }

    // Eliminar
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        if (!fidelizacionRepositorio.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        fidelizacionRepositorio.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
