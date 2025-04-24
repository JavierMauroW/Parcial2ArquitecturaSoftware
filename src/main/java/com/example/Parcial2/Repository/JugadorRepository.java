package com.example.Parcial2.Repository;


import com.example.Parcial2.Model.Jugador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JugadorRepository extends JpaRepository<Jugador, Integer> {


    @Query(value = "SELECT * FROM jugador WHERE id_equipo = :teamId", nativeQuery = true)
    List<Jugador> findByEquipo(@Param("teamId") Integer teamId);


    @Query(value =
            "SELECT j.* FROM jugador j " +
                    "JOIN estadisticas_jugador ej ON j.id_jugador = ej.id_jugador " +
                    "GROUP BY j.id_jugador, j.nombre, j.posicion, j.dorsal, j.fecha_nac, j.nacionalidad, j.id_equipo " +
                    "HAVING SUM(ej.goles) > :goles",
            nativeQuery = true)
    List<Jugador> findJugadoresConMasGoles(@Param("goles") Integer goles);
}