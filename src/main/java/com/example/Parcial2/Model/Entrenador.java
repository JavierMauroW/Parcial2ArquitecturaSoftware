package com.example.Parcial2.Model;


import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

@Entity
@Table(name = "entrenador")
public class Entrenador {

    @Id
    @Column(name = "id_entrenador")
    private Integer idEntrenador;

    @Column(length = 100, nullable = false)
    private String nombre;

    @Column(length = 100)
    private String especialidad;

    @ManyToOne
    @JoinColumn(name = "id_equipo", nullable = false)
    @JsonBackReference
    private Equipo equipo;

    public Entrenador() {
    }

    public Entrenador(Integer idEntrenador, String nombre, String especialidad, Equipo equipo) {
        this.idEntrenador = idEntrenador;
        this.nombre = nombre;
        this.especialidad = especialidad;
        this.equipo = equipo;
    }

    public Integer getIdEntrenador() {
        return idEntrenador;
    }

    public void setIdEntrenador(Integer idEntrenador) {
        this.idEntrenador = idEntrenador;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public Equipo getEquipo() {
        return equipo;
    }

    public void setEquipo(Equipo equipo) {
        this.equipo = equipo;
    }

    @Override
    public String toString() {
        return "Entrenador{" +
                "idEntrenador=" + idEntrenador +
                ", nombre='" + nombre + '\'' +
                ", especialidad='" + especialidad + '\'' +
                ", equipo=" + equipo +
                '}';
    }
}

