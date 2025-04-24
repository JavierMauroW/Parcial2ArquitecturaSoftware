package com.example.Parcial2.Service;



import com.example.Parcial2.Model.Entrenador;
import com.example.Parcial2.Repository.EntrenadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EntrenadorService {

    @Autowired
    private EntrenadorRepository repo;

    public List<Entrenador> findAll() {
        return repo.findAll();
    }

    public Optional<Entrenador> findById(Integer id) {
        return repo.findById(id);
    }

    public Entrenador save(Entrenador e) {
        return repo.save(e);
    }

    public void deleteById(Integer id) {
        repo.deleteById(id);
    }
}
