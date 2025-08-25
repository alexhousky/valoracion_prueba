package com.example.fidelidad_api.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "clientes")
@Getter
@Setter
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_clientes")
    private Integer idClientes;

    @ManyToOne
    @JoinColumn(name = "id_identificacion", referencedColumnName = "id_identificacion")
    private TipoIdentificacion tipoIdentificacion;

    @Column(name = "numero_identificacion", nullable = false, unique = true, length = 20)
    private String numeroIdentificacion;

    @Column(name = "nombres", nullable = false, length = 100)
    private String nombres;

    @Column(name = "apellidos", nullable = false, length = 100)
    private String apellidos;

    @Column(name = "fecha_nacimiento", nullable = false)
    private LocalDate fechaNacimiento;

    @Column(name = "direccion", nullable = false, length = 200)
    private String direccion;

    @ManyToOne
    @JoinColumn(name = "ciudad_id", referencedColumnName = "id_ciudad")
    private Ciudad ciudad;

    @ManyToOne
    @JoinColumn(name = "marca_id", referencedColumnName = "id_marcas")
    private Marca marca;
}

