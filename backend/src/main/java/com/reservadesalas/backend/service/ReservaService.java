package com.reservadesalas.backend.service;

import java.util.List;

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
}
