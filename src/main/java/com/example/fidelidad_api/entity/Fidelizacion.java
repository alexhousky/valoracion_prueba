package com.example.fidelidad_api.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "fidelizacion")
@Getter
@Setter
public class Fidelizacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_fidelizacion")
    private Integer idFidelizacion;

    @ManyToOne
    @JoinColumn(name = "cliente", referencedColumnName = "id_clientes")
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "marca", referencedColumnName = "id_marcas")
    private Marca marca;
}


