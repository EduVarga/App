package jpaswing.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "fichajes")
public class Fichaje {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String foto;
    private String nombre;
    private String tipo;
    private String anterior;
    private String actual;
    private String precio;
    public Fichaje(){

    }

    public Fichaje(String foto, String nombre, String tipo, String anterior, String actual, String precio) {
        this.foto = foto;
        this.nombre = nombre;
        this.tipo = tipo;
        this.anterior = anterior;
        this.actual = actual;
        this.precio = precio;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getAnterior() {
        return anterior;
    }

    public void setAnterior(String anterior) {
        this.anterior = anterior;
    }

    public String getActual() {
        return actual;
    }

    public void setActual(String actual) {
        this.actual = actual;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }
    @Override
    public String toString(){
        return foto + " - " + nombre + " - " + tipo + " - " + anterior + " - " + actual + " - " + precio;
    }
}
