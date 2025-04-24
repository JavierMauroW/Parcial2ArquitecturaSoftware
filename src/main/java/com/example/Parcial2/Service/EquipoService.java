package com.example.Parcial2.Service;



import com.example.Parcial2.Model.Equipo;
import com.example.Parcial2.Repository.EquipoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EquipoService {

    @Autowired
    private EquipoRepository repo;

    public List<Equipo> findAll() {
        return repo.findAll();
    }

    public Optional<Equipo> findById(Integer id) {
        return repo.findById(id);
    }

    public Equipo save(Equipo equipo) {
        return repo.save(equipo);
    }

    public void deleteById(Integer id) {
        repo.deleteById(id);
    }

    public Integer getTotalGolesPorEquipo(Integer teamId) {
        return repo.totalGolesPorEquipo(teamId);
    }
}