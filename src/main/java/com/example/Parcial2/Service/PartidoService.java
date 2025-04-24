package com.example.Parcial2.Service;


import com.example.Parcial2.Model.Partido;
import com.example.Parcial2.Repository.PartidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PartidoService {

    @Autowired
    private PartidoRepository repo;

    public List<Partido> findAll() {
        return repo.findAll();
    }

    public Optional<Partido> findById(Integer id) {
        return repo.findById(id);
    }

    public Partido save(Partido partido) {
        return repo.save(partido);
    }

    public void deleteById(Integer id) {
        repo.deleteById(id);
    }

    public List<Object[]> getResultadosConNombres() {
        return repo.obtenerResultadosPartidosConNombres();
    }
}
