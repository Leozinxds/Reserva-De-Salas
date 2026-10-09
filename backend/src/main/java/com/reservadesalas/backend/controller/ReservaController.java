package com.reservadesalas.backend.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.reservadesalas.backend.dto.ReservaDTO;
import com.reservadesalas.backend.service.ReservaService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@RestController 
@RequestMapping ("/reservas")
@Tag (name = "Reservas", description = "CRUD operations for reservas")
public class ReservaController {
    private final ReservaService reservaService;

    public ReservaController(ReservaService reservaService){
        this.reservaService = reservaService;
    }

    @GetMapping
    public List<ReservaDTO> getAll(){
        return reservaService.getAllReservas();
    }
    
    @GetMapping ("/{id}")
    public ResponseEntity<ReservaDTO> getById(@PathVariable Long id){
        return reservaService.getReservaById(id)
        .map(ResponseEntity::ok)
        .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping 
    public ResponseEntity<ReservaDTO> create(@Valid @RequestBody ReservaDTO reservaDTO){
        return ResponseEntity.status(201)
        .body(reservaService
        .createReserva(reservaDTO));
    }

    @PutMapping ("/{id}")
    public ResponseEntity update(@PathVariable Long id, @Valid @RequestBody ReservaDTO reservaDTO){
        return reservaService.updateReserva(id, reservaDTO)
        .map(ResponseEntity::ok)
        .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping ("/{id}")
    public ResponseEntity<Void> deletea(@PathVariable Long id){
        return reservaService.deleteReserva(id)
        ? ResponseEntity.noContent().build()
        : ResponseEntity.notFound().build();
    }

    @PatchMapping ("/{id}/confirmar")
    public ResponseEntity<ReservaDTO> confirmar(@PathVariable Long id){
        return reservaService.confirmarReserva(id)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }
    

}
