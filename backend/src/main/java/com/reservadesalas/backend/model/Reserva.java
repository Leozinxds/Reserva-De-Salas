package com.reservadesalas.backend.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity 
@Table (name = "reservas")
public class Reserva {
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY);
    private Long id;

    @Column(nullable = false, length = 100);
    private String recurso;

    @Column(nullable = false, length = 100);
    private String responsavel;
}
