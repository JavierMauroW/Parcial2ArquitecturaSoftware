package com.example.Parcial2.Repository;


import com.example.Parcial2.Model.EstadisticasJugador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EstadisticasJugadorRepository extends JpaRepository<EstadisticasJugador, Integer> {


    List<EstadisticasJugador> findByJugadorIdJugador(Integer jugadorId);

    @Query(value =
            "SELECT ej.* FROM estadisticas_jugador ej " +
                    "JOIN jugador j ON ej.id_jugador = j.id_jugador " +
                    "WHERE j.id_equipo = :teamId",
            nativeQuery = true)
    List<EstadisticasJugador> findStatsByEquipo(@Param("teamId") Integer teamId);

    @Query(value =
            "SELECT j.id_jugador, j.nombre, SUM(ej.goles) AS total_goles " +
                    "FROM jugador j " +
                    "JOIN estadisticas_jugador ej ON j.id_jugador = ej.id_jugador " +
                    "GROUP BY j.id_jugador, j.nombre " +
                    "HAVING SUM(ej.goles) > :goles",
            nativeQuery = true)
    List<Object[]> findJugadoresConMasGoles(@Param("goles") Integer goles);

}