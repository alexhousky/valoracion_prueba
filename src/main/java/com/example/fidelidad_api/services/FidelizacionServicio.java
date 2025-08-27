// src/main/java/com/example/fidelidad_api/services/FidelizacionServicio.java
package com.example.fidelidad_api.services;

import com.example.fidelidad_api.dtos.ActualizarEstadoFidelizacionDTO;
import com.example.fidelidad_api.dtos.CrearFidelizacionDTO;
import com.example.fidelidad_api.dtos.FidelizacionDTO;
import com.example.fidelidad_api.models.*;
import com.example.fidelidad_api.repositories.FidelizacionRepositorio;
import com.example.fidelidad_api.repositories.ClienteRepositorio;
import com.example.fidelidad_api.repositories.MarcaRepositorio;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class FidelizacionServicio {

    private final FidelizacionRepositorio fidelizacionRepositorio;
    private final ClienteRepositorio clienteRepositorio;
    private final MarcaRepositorio marcaRepositorio;

    public FidelizacionServicio(FidelizacionRepositorio fidelizacionRepositorio,
                                ClienteRepositorio clienteRepositorio,
                                MarcaRepositorio marcaRepositorio) {
        this.fidelizacionRepositorio = fidelizacionRepositorio;
        this.clienteRepositorio = clienteRepositorio;
        this.marcaRepositorio = marcaRepositorio;
    }

    public FidelizacionDTO crear(CrearFidelizacionDTO dto) {
        // Validar existencia de cliente y marca
        Cliente cliente = clienteRepositorio.findById(dto.getClienteId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente no encontrado"));
        Marca marca = marcaRepositorio.findById(dto.getMarcaId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Marca no encontrada"));

        // Validar duplicado
        if (fidelizacionRepositorio.existsByClienteIdAndMarcaId(dto.getClienteId(), dto.getMarcaId())) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "El cliente ya está afiliado a esta marca");
        }

        Fidelizacion f = new Fidelizacion();
        f.setCliente(cliente);
        f.setMarca(marca);
        f.setFechaInicio(dto.getFechaInicio()); // si es null, @PrePersist pondrá hoy
        f.setEstado(EstadoFidelizacion.ACTIVO);

        Fidelizacion guardado = fidelizacionRepositorio.save(f);
        return toDTO(guardado);
    }

    @Transactional(readOnly = true)
    public FidelizacionDTO obtener(Integer id) {
        Fidelizacion f = fidelizacionRepositorio.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Fidelización no encontrada"));
        return toDTO(f);
    }

    @Transactional(readOnly = true)
    public FidelizacionDTO obtenerPorClienteYMarca(Integer clienteId, Integer marcaId) {
        Fidelizacion f = fidelizacionRepositorio.findByClienteIdAndMarcaId(clienteId, marcaId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Fidelización cliente-marca no encontrada"));
        return toDTO(f);
    }

    @Transactional(readOnly = true)
    public List<FidelizacionDTO> listarPorCliente(Integer clienteId) {
        return fidelizacionRepositorio.findByClienteId(clienteId).stream()
                .map(this::toDTO).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public List<FidelizacionDTO> listarPorMarca(Integer marcaId) {
        return fidelizacionRepositorio.findByMarcaId(marcaId).stream()
                .map(this::toDTO).collect(Collectors.toList());
    }

    public FidelizacionDTO actualizarEstado(Integer id, ActualizarEstadoFidelizacionDTO dto) {
        Fidelizacion f = fidelizacionRepositorio.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Fidelización no encontrada"));
        f.setEstado(dto.getEstado());
        return toDTO(f); // JPA flush on commit
    }

    public void eliminar(Integer id) {
        if (!fidelizacionRepositorio.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Fidelización no encontrada");
        }
        fidelizacionRepositorio.deleteById(id);
    }

    // Mapper
    private FidelizacionDTO toDTO(Fidelizacion f) {
        FidelizacionDTO dto = new FidelizacionDTO();
        dto.setId(f.getId());
        dto.setClienteId(f.getCliente().getId());
        dto.setMarcaId(f.getMarca().getId());
        dto.setFechaInicio(f.getFechaInicio());
        dto.setEstado(f.getEstado());
        // Campos de apoyo (si tus entidades los tienen con estos nombres)
        String clienteNombre = (f.getCliente().getNombres() != null ? f.getCliente().getNombres() : "") +
                " " +
                (f.getCliente().getApellidos() != null ? f.getCliente().getApellidos() : "");
        dto.setClienteNombreCompleto(clienteNombre.trim());
        dto.setMarcaNombre(f.getMarca().getNombre());
        return dto;
    }
}
