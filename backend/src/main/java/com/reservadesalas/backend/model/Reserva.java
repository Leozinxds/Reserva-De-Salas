package com.reservadesalas.backend.model;

import java.time.LocalDateTime;

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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String recurso;

    @Column(nullable = false, length = 100)
    private String responsavel;

    @Column (nullable = false)
    private LocalDateTime dataHora;

    @Column (nullable = false)
    private int capacidade;

    @Column (nullable = false)
    private Boolean confirmada = false;

    public Reserva() {

    }

    public Reserva(String recurso, String responsavel, LocalDateTime dataHora, int capacidade) {
        this.recurso = recurso;
        this.responsavel = responsavel;
        this.dataHora = dataHora;
        this.capacidade = capacidade;
    }


    //Getters
    public Long getId() {
        return id;
    }

    public String getRecurso() {
        return recurso;
    }

    public String getResponsavel() {
        return responsavel;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public int getCapacidade() {
        return capacidade;
    }

    public Boolean getConfirmada() {
        return confirmada;
    }

    //Setters
    public void setRecurso(String recurso) {
        this.recurso = recurso;
    }

    public void setResponsavel(String responsavel) {
        this.responsavel = responsavel;
    }

    public void setDataHora(LocalDateTime dataHora) {
        this.dataHora = dataHora;
    }

    public void setCapacidade(int capacidade) {
        this.capacidade = capacidade;
    }

    public void setConfirmada(Boolean confirmada) {
        this.confirmada = confirmada;
    }

    @Override
    public String toString() {
        return "Reserva{id = " + id + ", recurso = " + recurso +
                ", responsável = " + responsavel + ", data = " + dataHora + ", capacidade = " + capacidade + ", status = " + confirmada + "}";
    }

}


