package com.reservadesalas.backend.mapper;

import com.reservadesalas.backend.dto.ReservaDTO;
import com.reservadesalas.backend.model.Reserva;

public class ReservaMapper {
    
    private ReservaMapper(){}

    public static ReservaDTO toDTO(Reserva reserva){
        return new ReservaDTO(
            reserva.getId(), 
            reserva.getRecurso(), 
            reserva.getResponsavel(), 
            reserva.getDataHora(), 
            reserva.getCapacidade(), 
            reserva.getConfirmada()
        );
    }
    
    public static Reserva toEntity(ReservaDTO reservaDTO){
        return new Reserva(
            reservaDTO.getRecurso(),
            reservaDTO.getResponsavel(),
            reservaDTO.getDataHora(),
            reservaDTO.getCapacidade(),
            reservaDTO.getConfirmada()
        );
    }

}
