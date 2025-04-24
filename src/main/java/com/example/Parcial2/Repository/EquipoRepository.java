package com.example.Parcial2.Repository;


import com.example.Parcial2.Model.Equipo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface EquipoRepository extends JpaRepository<Equipo, Integer> {


    @Query(value = "SELECT COALESCE(\n" +
            "  SUM(CASE WHEN equipo_local = :teamId THEN goles_local ELSE 0 END) +\n" +
            "  SUM(CASE WHEN equipo_visita = :teamId THEN goles_visita ELSE 0 END), 0)\n" +
            "FROM partido\n" +
            "WHERE equipo_local = :teamId OR equipo_visita = :teamId",
            nativeQuery = true)
    Integer totalGolesPorEquipo(@Param("teamId") Integer teamId);
}