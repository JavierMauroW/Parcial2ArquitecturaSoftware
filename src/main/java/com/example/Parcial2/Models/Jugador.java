package com.example.Parcial2.Models;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "jugador")
public class Jugador {

    @Id
    @Column(name = "id_jugador")
    private Integer idJugador;

    @Column(length = 100, nullable = false)
    private String nombre;

    @Column(length = 50)
    private String posicion;

    private Integer dorsal;

    private LocalDate fechaNac;

    @Column(length = 100)
    private String nacionalidad;

    @ManyToOne
    @JoinColumn(name = "id_equipo", nullable = false)
    private Equipo equipo;

    @OneToMany(mappedBy = "jugador", cascade = CascadeType.ALL)
    private List<EstadisticasJugador> estadisticas;

    public Jugador(){
    }

    public Jugador(Integer idJugador, String nombre, String posicion, Integer dorsal, LocalDate fechaNac, String nacionalidad, Equipo equipo, List<EstadisticasJugador> estadisticas) {
        this.idJugador = idJugador;
        this.nombre = nombre;
        this.posicion = posicion;
        this.dorsal = dorsal;
        this.fechaNac = fechaNac;
        this.nacionalidad = nacionalidad;
        this.equipo = equipo;
        this.estadisticas = estadisticas;
    }

    public Integer getIdJugador() {
        return idJugador;
    }

    public void setIdJugador(Integer idJugador) {
        this.idJugador = idJugador;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPosicion() {
        return posicion;
    }

    public void setPosicion(String posicion) {
        this.posicion = posicion;
    }

    public Integer getDorsal() {
        return dorsal;
    }

    public void setDorsal(Integer dorsal) {
        this.dorsal = dorsal;
    }

    public LocalDate getFechaNac() {
        return fechaNac;
    }

    public void setFechaNac(LocalDate fechaNac) {
        this.fechaNac = fechaNac;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public Equipo getEquipo() {
        return equipo;
    }

    public void setEquipo(Equipo equipo) {
        this.equipo = equipo;
    }

    public List<EstadisticasJugador> getEstadisticas() {
        return estadisticas;
    }

    public void setEstadisticas(List<EstadisticasJugador> estadisticas) {
        this.estadisticas = estadisticas;
    }

    @Override
    public String toString() {
        return "Jugador{" +
                "idJugador=" + idJugador +
                ", nombre='" + nombre + '\'' +
                ", posicion='" + posicion + '\'' +
                ", dorsal=" + dorsal +
                ", fechaNac=" + fechaNac +
                ", nacionalidad='" + nacionalidad + '\'' +
                ", equipo=" + equipo +
                ", estadisticas=" + estadisticas +
                '}';
    }
}

