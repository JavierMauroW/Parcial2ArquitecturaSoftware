package com.example.Parcial2.Service;


import com.example.Parcial2.Model.Jugador;
import com.example.Parcial2.Repository.JugadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JugadorService {

    @Autowired
    private JugadorRepository repo;

    public List<Jugador> findAll() {
        return repo.findAll();
    }

    public Optional<Jugador> findById(Integer id) {
        return repo.findById(id);
    }

    public Jugador save(Jugador jugador) {
        return repo.save(jugador);
    }

    public void deleteById(Integer id) {
        repo.deleteById(id);
    }

    public List<Jugador> getByEquipo(Integer teamId) {
        return repo.findByEquipo(teamId);
    }

    public List<Jugador> getJugadoresConMasGoles(Integer goles) {
        return repo.findJugadoresConMasGoles(goles);
    }
}
