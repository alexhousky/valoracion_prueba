package com.example.fidelidad_api.dtos;

public class ClienteDTO {

    private Long id;
    private String numeroIdentificacion;
    private String nombres;
    private String apellidos;
    private String tipoIdentificacion;
    private String ciudad;

    public ClienteDTO(Long id, String numeroIdentificacion, String nombres, String apellidos, String tipoIdentificacion, String ciudad) {
        this.id = id;
        this.numeroIdentificacion = numeroIdentificacion;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.tipoIdentificacion = tipoIdentificacion;
        this.ciudad = ciudad;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNumeroIdentificacion() { return numeroIdentificacion; }
    public void setNumeroIdentificacion(String numeroIdentificacion) { this.numeroIdentificacion = numeroIdentificacion; }

    public String getNombres() { return nombres; }
    public void setNombres(String nombres) { this.nombres = nombres; }

    public String getApellidos() { return apellidos; }
    public void setApellidos(String apellidos) { this.apellidos = apellidos; }

    public String getTipoIdentificacion() { return tipoIdentificacion; }
    public void setTipoIdentificacion(String tipoIdentificacion) { this.tipoIdentificacion = tipoIdentificacion; }

    public String getCiudad() { return ciudad; }
    public void setCiudad(String ciudad) { this.ciudad = ciudad; }
}
