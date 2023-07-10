package com.isilep4.isilnet.entidades;

import jakarta.persistence.*;
import lombok.Data;


import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Data
@Table
public class Visita {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "local", nullable = false, length = 150)
    private String local;

    @Column(name = "dni_afiliado", nullable = false, length = 8)
    private String dniAfiliado;
    @Column(name = "fecha")
    private LocalDate fecha;
    @Column(name = "hora")
    private LocalTime hora;
}
