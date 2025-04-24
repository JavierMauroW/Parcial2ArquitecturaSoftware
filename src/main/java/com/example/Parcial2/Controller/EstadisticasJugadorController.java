package com.example.Parcial2.Controller;

import com.example.Parcial2.Model.EstadisticasJugador;
import com.example.Parcial2.Service.EstadisticasJugadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/estadisticas")
public class EstadisticasJugadorController {

    @Autowired
    private EstadisticasJugadorService service;


    @GetMapping
    public ResponseEntity<List<EstadisticasJugador>> getAll() {
        return ResponseEntity.ok(service.findAll());
    }


    @GetMapping("/{id}")
    public ResponseEntity<EstadisticasJugador> getById(@PathVariable Integer id) {
        return service.findById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }


    @GetMapping("/jugador/{jugadorId}")
    public ResponseEntity<List<EstadisticasJugador>> getByJugador(@PathVariable Integer jugadorId) {
        return ResponseEntity.ok(service.getStatsByJugador(jugadorId));
    }


    @GetMapping("/equipo/{teamId}")
    public ResponseEntity<List<EstadisticasJugador>> getByEquipo(@PathVariable Integer teamId) {
        return ResponseEntity.ok(service.getStatsByEquipo(teamId));
    }


    @GetMapping("/jugadores-mas-goles/{goles}")
    public ResponseEntity<List<Object[]>> getJugadoresConMasGoles(@PathVariable Integer goles) {
        return ResponseEntity.ok(service.getJugadoresConMasGoles(goles));
    }


    @PostMapping
    public ResponseEntity<EstadisticasJugador> create(@RequestBody EstadisticasJugador ej) {
        EstadisticasJugador saved = service.save(ej);
        return ResponseEntity.ok(saved);
    }


    @PutMapping("/{id}")
    public ResponseEntity<EstadisticasJugador> update(
            @PathVariable Integer id,
            @RequestBody EstadisticasJugador ej
    ) {
        return service.findById(id)
                .map(existing -> {
                    ej.setIdEstadistica(existing.getIdEstadistica());
                    return ResponseEntity.ok(service.save(ej));
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        if (!service.findById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}