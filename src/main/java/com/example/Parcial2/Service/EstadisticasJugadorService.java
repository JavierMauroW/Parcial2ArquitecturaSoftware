package com.example.Parcial2.Service;



import com.example.Parcial2.Model.EstadisticasJugador;
import com.example.Parcial2.Repository.EstadisticasJugadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EstadisticasJugadorService {

    @Autowired
    private EstadisticasJugadorRepository repo;

    public List<EstadisticasJugador> findAll() {
        return repo.findAll();
    }

    public Optional<EstadisticasJugador> findById(Integer id) {
        return repo.findById(id);
    }

    public EstadisticasJugador save(EstadisticasJugador ej) {
        return repo.save(ej);
    }

    public void deleteById(Integer id) {
        repo.deleteById(id);
    }

    public List<EstadisticasJugador> getStatsByJugador(Integer jugadorId) {
        return repo.findByJugadorIdJugador(jugadorId);
    }

    public List<EstadisticasJugador> getStatsByEquipo(Integer teamId) {
        return repo.findStatsByEquipo(teamId);
    }

    public List<Object[]> getJugadoresConMasGoles(Integer goles) {
        return repo.findJugadoresConMasGoles(goles);
    }
}
