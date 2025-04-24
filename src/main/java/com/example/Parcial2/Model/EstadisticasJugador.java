package com.example.Parcial2.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

@Entity
@Table(name = "estadisticas_jugador")
public class EstadisticasJugador {

    @Id
    @Column(name = "id_estadistica")
    private Integer idEstadistica;

    @ManyToOne
    @JoinColumn(name = "id_jugador", nullable = false)
    @JsonBackReference
    private Jugador jugador;

    @ManyToOne
    @JoinColumn(name = "id_partido", nullable = false)
    private Partido partido;

    private Integer minutosJugados;

    private Integer goles;

    private Integer asistencias;

    private Integer tarjetasAmarillas;

    private Integer tarjetasRojas;

    private EstadisticasJugador(){
    }

    public EstadisticasJugador(Integer idEstadistica, Jugador jugador, Partido partido, Integer minutosJugados, Integer goles, Integer asistencias, Integer tarjetasAmarillas, Integer tarjetasRojas) {
        this.idEstadistica = idEstadistica;
        this.jugador = jugador;
        this.partido = partido;
        this.minutosJugados = minutosJugados;
        this.goles = goles;
        this.asistencias = asistencias;
        this.tarjetasAmarillas = tarjetasAmarillas;
        this.tarjetasRojas = tarjetasRojas;
    }

    public Integer getIdEstadistica() {
        return idEstadistica;
    }

    public void setIdEstadistica(Integer idEstadistica) {
        this.idEstadistica = idEstadistica;
    }

    public Jugador getJugador() {
        return jugador;
    }

    public void setJugador(Jugador jugador) {
        this.jugador = jugador;
    }

    public Partido getPartido() {
        return partido;
    }

    public void setPartido(Partido partido) {
        this.partido = partido;
    }

    public Integer getMinutosJugados() {
        return minutosJugados;
    }

    public void setMinutosJugados(Integer minutosJugados) {
        this.minutosJugados = minutosJugados;
    }

    public Integer getGoles() {
        return goles;
    }

    public void setGoles(Integer goles) {
        this.goles = goles;
    }

    public Integer getAsistencias() {
        return asistencias;
    }

    public void setAsistencias(Integer asistencias) {
        this.asistencias = asistencias;
    }

    public Integer getTarjetasAmarillas() {
        return tarjetasAmarillas;
    }

    public void setTarjetasAmarillas(Integer tarjetasAmarillas) {
        this.tarjetasAmarillas = tarjetasAmarillas;
    }

    public Integer getTarjetasRojas() {
        return tarjetasRojas;
    }

    public void setTarjetasRojas(Integer tarjetasRojas) {
        this.tarjetasRojas = tarjetasRojas;
    }

    @Override
    public String toString() {
        return "EstadisticasJugador{" +
                "idEstadistica=" + idEstadistica +
                ", jugador=" + jugador +
                ", partido=" + partido +
                ", minutosJugados=" + minutosJugados +
                ", goles=" + goles +
                ", asistencias=" + asistencias +
                ", tarjetasAmarillas=" + tarjetasAmarillas +
                ", tarjetasRojas=" + tarjetasRojas +
                '}';
    }
}
