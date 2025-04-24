package com.example.Parcial2.Controller;


import com.example.Parcial2.Model.Jugador;
import com.example.Parcial2.Service.JugadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/jugadores")
public class JugadorController {

    private final JugadorService service;

    @Autowired
    public JugadorController(JugadorService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<Jugador>> getAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Jugador> getById(@PathVariable Integer id) {
        return service.findById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/equipo/{teamId}")
    public ResponseEntity<List<Jugador>> getByEquipo(@PathVariable Integer teamId) {
        return ResponseEntity.ok(service.getByEquipo(teamId));
    }

    @GetMapping("/goles/{goles}")
    public ResponseEntity<List<Jugador>> getJugadoresConMasGoles(@PathVariable Integer goles) {
        return ResponseEntity.ok(service.getJugadoresConMasGoles(goles));
    }

    @PostMapping
    public ResponseEntity<Jugador> create(@RequestBody Jugador jugador) {
        return ResponseEntity.ok(service.save(jugador));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Jugador> update(
            @PathVariable Integer id,
            @RequestBody Jugador jugador
    ) {
        return service.findById(id)
                .map(existing -> {
                    jugador.setIdJugador(existing.getIdJugador());
                    return ResponseEntity.ok(service.save(jugador));
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
