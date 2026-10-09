package com.reservadesalas.backend.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import  com.reservadesalas.backend.dto.ReservaDTO;
import  com.reservadesalas.backend.mapper.ReservaMapper;
import  com.reservadesalas.backend.repository.ReservaRepository;

@Service
public class ReservaService {

    private final ReservaMapper reservaMapper;
    private final ReservaRepository reservaRepository;

    public ReservaService(ReservaRepository reservaRepository, ReservaMapper reservaMapper){
        this.reservaRepository = reservaRepository;
        this.reservaMapper = reservaMapper;
    }

    public List<ReservaDTO> getAllReservas(){
        return reservaRepository.findAll()
        .stream()
        .map(ReservaMapper::toDTO)
        .toList();
    }

    public Optional<ReservaDTO> confirmarReserva(Long id) {
        return reservaRepository.findById(id)
        .map(reserva -> {
        reserva.setConfirmada(true);
            return ReservaMapper.toDTO(
                reservaRepository.save(reserva)
            );
        });

    }

    public Optional<ReservaDTO> getReservaById(Long id){
        return reservaRepository.findById(id)
        .map(ReservaMapper::toDTO);
    }

    public ReservaDTO createReserva(ReservaDTO reservaDTO){
        return ReservaMapper.toDTO(
            reservaRepository.save(
                ReservaMapper.toEntity(reservaDTO)
            ));
    }       

    public Optional<ReservaDTO> updateReserva(Long id, ReservaDTO reservaDTO){
        return reservaRepository.findById(id)
        .map(reserva ->{
            reserva.setRecurso(reservaDTO.getRecurso());
            reserva.setResponsavel(reservaDTO.getResponsavel());
            reserva.setDataHora(reservaDTO.getDataHora());
            reserva.setCapacidade(reservaDTO.getCapacidade());
            return ReservaMapper.toDTO(
                reservaRepository.save(reserva));
        });
    }

    public boolean deleteReserva(Long id){
        if(!reservaRepository.existsById(id)) return false;
        reservaRepository.deleteById(id);
        return true;
    }

}



