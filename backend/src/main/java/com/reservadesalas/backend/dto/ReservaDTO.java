package com.reservadesalas.backend.dto;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Schema(description = "Reservation data transfer object")
public class ReservaDTO {
    
    @Schema(description = "Unique identifier of the reservation", example = "1", accessMode = Schema.AccessMode.READ_ONLY)
    private Long id;

    @NotBlank(message = "Resource is required")
    @Size(min = 2, max = 100, message = "Name must be between 2 and 100 chacacters")
    @Schema(description = "Short description of the room", example = "Computer Lab 01")
    private String recurso;

    @NotBlank(message = "Owner is required")
    @Size(min = 2, max = 100, message = "Name must be between 2 and 100 chacacters")
    @Schema(description = "Name of the person responsible for the reservation", example = "Eduardo")
    private String responsavel;

    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    @Schema(description = "Date and time of the reservation", example = "2026-09-22T12:30")
    private LocalDateTime dataHora;

    @Min(value = 0, message = "Capacity cannot be negative")
    @Schema(description = "Maximum number of people allowed in the reservation", example = "30")
    private int capacidade;

    @Schema(description = "Indicates if the reservation has been confirmed",
    example = "false",
    accessMode = Schema.AccessMode.READ_ONLY)
    private Boolean confirmada;

    public ReservaDTO(Long id, String recurso, String responsavel, LocalDateTime dataHora, int capacidade, Boolean confirmada){
        this.id = id;
        this.recurso = recurso;
        this.responsavel = responsavel;
        this.dataHora = dataHora;
        this.capacidade = capacidade;
        this.confirmada = confirmada;
    }

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

    public void setId(Long id) {
        this.id = id;
    }

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
}
