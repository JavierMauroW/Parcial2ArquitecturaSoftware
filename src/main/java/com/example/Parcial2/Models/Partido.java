package com.example.Parcial2.Models;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "partido")
public class Partido {

    @Id
    @Column(name = "id_partido")
    private Integer idPartido;

    private LocalDate fecha;

    @Column(length = 100)
    private String estadio;

    @ManyToOne
    @JoinColumn(name = "equipo_local", nullable = false)
    private Equipo equipoLocal;

    @ManyToOne
    @JoinColumn(name = "equipo_visita", nullable = false)
    private Equipo equipoVisita;

    private Integer golesLocal;

    private Integer golesVisita;

    @OneToMany(mappedBy = "partido", cascade = CascadeType.ALL)
    private List<EstadisticasJugador> estadisticas;

    public Partido(){
    }

    public Partido(Integer idPartido, LocalDate fecha, String estadio, Equipo equipoLocal, Equipo equipoVisita, Integer golesLocal, Integer golesVisita, List<EstadisticasJugador> estadisticas) {
        this.idPartido = idPartido;
        this.fecha = fecha;
        this.estadio = estadio;
        this.equipoLocal = equipoLocal;
        this.equipoVisita = equipoVisita;
        this.golesLocal = golesLocal;
        this.golesVisita = golesVisita;
        this.estadisticas = estadisticas;
    }

    public Integer getIdPartido() {
        return idPartido;
    }

    public void setIdPartido(Integer idPartido) {
        this.idPartido = idPartido;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public String getEstadio() {
        return estadio;
    }

    public void setEstadio(String estadio) {
        this.estadio = estadio;
    }

    public Equipo getEquipoLocal() {
        return equipoLocal;
    }

    public void setEquipoLocal(Equipo equipoLocal) {
        this.equipoLocal = equipoLocal;
    }

    public Equipo getEquipoVisita() {
        return equipoVisita;
    }

    public void setEquipoVisita(Equipo equipoVisita) {
        this.equipoVisita = equipoVisita;
    }

    public Integer getGolesLocal() {
        return golesLocal;
    }

    public void setGolesLocal(Integer golesLocal) {
        this.golesLocal = golesLocal;
    }

    public Integer getGolesVisita() {
        return golesVisita;
    }

    public void setGolesVisita(Integer golesVisita) {
        this.golesVisita = golesVisita;
    }

    public List<EstadisticasJugador> getEstadisticas() {
        return estadisticas;
    }

    public void setEstadisticas(List<EstadisticasJugador> estadisticas) {
        this.estadisticas = estadisticas;
    }

    @Override
    public String toString() {
        return "Partido{" +
                "idPartido=" + idPartido +
                ", fecha=" + fecha +
                ", estadio='" + estadio + '\'' +
                ", equipoLocal=" + equipoLocal +
                ", equipoVisita=" + equipoVisita +
                ", golesLocal=" + golesLocal +
                ", golesVisita=" + golesVisita +
                ", estadisticas=" + estadisticas +
                '}';
    }
}
