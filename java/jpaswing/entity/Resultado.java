package jpaswing.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "resultados")
public class Resultado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String partido;
    private String equipo;
    private String imagen;
    private int dorsal;
    private String nombre;
    public Resultado(){

    }

    public Resultado(String partido, String equipo, String imagen, int dorsal, String nombre) {
        this.partido = partido;
        this.equipo = equipo;
        this.imagen = imagen;
        this.dorsal = dorsal;
        this.nombre = nombre;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPartido() {
        return partido;
    }

    public void setPartido(String partido) {
        this.partido = partido;
    }

    public String getEquipo() {
        return equipo;
    }

    public void setEquipo(String equipo) {
        this.equipo = equipo;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public int getDorsal() {
        return dorsal;
    }

    public void setDorsal(int dorsal) {
        this.dorsal = dorsal;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    @Override
    public String toString(){
        return partido + " - " + equipo + " - " + imagen + " - " + dorsal + " - " + nombre;
    }
}
