package com.example.fidelidad_api.models;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "clientes")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_clientes")
    private Long idClientes;


    @ManyToOne
    @JoinColumn(name = "id_identificacion")
    private TipoIdentificacion tipoIdentificacion;

    @Column(unique = true, length = 20)
    private String numeroIdentificacion;

    @Column(length = 100)
    private String nombres;

    @Column(length = 100)
    private String apellidos;

    @Column()
    private LocalDate fecha_nacimiento;

    @Column(length = 150)
    private String direccion;

    @ManyToOne
    @JoinColumn(name = "ciudad_id")
    private Ciudad ciudad;

    @ManyToOne
    @JoinColumn(name = "marca_id")
    private Marca marca;

    // Getters y Setters

    public Long getIdClientes() {
        return idClientes;
    }

    public void setIdClientes(Long idClientes) {
        this.idClientes = idClientes;
    }

    public TipoIdentificacion getTipoIdentificacion() {
        return tipoIdentificacion;
    }

    public void setTipoIdentificacion(TipoIdentificacion tipoIdentificacion) {
        this.tipoIdentificacion = tipoIdentificacion;
    }

    public String getNumeroIdentificacion() {
        return numeroIdentificacion;
    }

    public void setNumeroIdentificacion(String numeroIdentificacion) {
        this.numeroIdentificacion = numeroIdentificacion;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public LocalDate getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public void setFecha_nacimiento(LocalDate fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Ciudad getCiudad() {
        return ciudad;
    }

    public void setCiudad(Ciudad ciudad) {
        this.ciudad = ciudad;
    }

    public Marca getMarca() {
        return marca;
    }

    public void setMarca(Marca marca) {
        this.marca = marca;
    }
}

