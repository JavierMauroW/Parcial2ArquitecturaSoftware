package com.example.Parcial2.Controller;


import com.example.Parcial2.Model.Partido;
import com.example.Parcial2.Service.PartidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/partidos")
public class PartidoController {

    @Autowired
    private PartidoService service;

    @GetMapping
    public ResponseEntity<List<Partido>> getAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Partido> getById(@PathVariable Integer id) {
        return service.findById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/resultados")
    public ResponseEntity<List<Object[]>> getResultadosConNombres() {
        return ResponseEntity.ok(service.getResultadosConNombres());
    }

    @PostMapping
    public ResponseEntity<Partido> create(@RequestBody Partido p) {
        return ResponseEntity.ok(service.save(p));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Partido> update(@PathVariable Integer id, @RequestBody Partido p) {
        return service.findById(id)
                .map(existing -> {
                    p.setIdPartido(existing.getIdPartido());
                    return ResponseEntity.ok(service.save(p));
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
