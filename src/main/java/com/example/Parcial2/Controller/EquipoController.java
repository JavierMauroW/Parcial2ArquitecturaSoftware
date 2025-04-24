package com.example.Parcial2.Controller;


import com.example.Parcial2.Model.Equipo;
import com.example.Parcial2.Service.EquipoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/equipos")
public class EquipoController {

    private final EquipoService service;

    @Autowired
    public EquipoController(EquipoService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<Equipo>> getAll() {
        return ResponseEntity.ok(service.findAll());
    }


    @GetMapping("/{id}")
    public ResponseEntity<Equipo> getById(@PathVariable("id") Integer id) {
        return service.findById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }


    @GetMapping("/{id}/goles")
    public ResponseEntity<Integer> getTotalGoles(@PathVariable("id") Integer id) {
        Integer total = service.getTotalGolesPorEquipo(id);
        return ResponseEntity.ok(total);
    }


    @PostMapping
    public ResponseEntity<Equipo> create(@RequestBody Equipo e) {
        Equipo saved = service.save(e);
        return ResponseEntity.ok(saved);
    }


    @PutMapping("/{id}")
    public ResponseEntity<Equipo> update(
            @PathVariable("id") Integer id,
            @RequestBody Equipo e
    ) {
        return service.findById(id)
                .map(existing -> {
                    e.setIdEquipo(existing.getIdEquipo());
                    Equipo updated = service.save(e);
                    return ResponseEntity.ok(updated);
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id) {

        if (!service.findById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
