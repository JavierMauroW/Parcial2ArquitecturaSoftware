package com.example.Parcial2.Controller;

import com.example.Parcial2.Model.Entrenador;
import com.example.Parcial2.Service.EntrenadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/entrenadores")
public class EntrenadorController {

    @Autowired
    private EntrenadorService service;

    // GET /entrenadores
    @GetMapping
    public List<Entrenador> getAll() {
        return service.findAll();
    }

    // GET /entrenadores/{id}
    @GetMapping("/{id}")
    public ResponseEntity<Entrenador> getById(@PathVariable Integer id) {
        return service.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // POST /entrenadores
    @PostMapping
    public ResponseEntity<Entrenador> create(@RequestBody Entrenador e) {
        Entrenador saved = service.save(e);
        return ResponseEntity.ok(saved);
    }

    // PUT /entrenadores/{id}
    @PutMapping("/{id}")
    public ResponseEntity<Entrenador> update(
            @PathVariable Integer id,
            @RequestBody Entrenador e
    ) {
        return service.findById(id)
                .map(existing -> {
                    e.setIdEntrenador(existing.getIdEntrenador());
                    return ResponseEntity.ok(service.save(e));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    // DELETE /entrenadores/{id}
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        return service.findById(id)
                .map(existing -> {
                    service.deleteById(id);
                    return ResponseEntity.noContent().<Void>build();
                })
                .orElse(ResponseEntity.notFound().build());
    }
}
