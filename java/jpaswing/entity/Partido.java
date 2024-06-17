package jpaswing.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "partidos")
public class Partido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String competicion;
    private String fecha;
    private String eqlocal;
    private String eqvisitante;
    private String hora;
    private String resultado;
    public Partido(){

    }

    public Partido(String competicion, String fecha, String eqlocal, String eqvisitante, String hora, String resultado) {
        this.competicion = competicion;
        this.fecha = fecha;
        this.eqlocal = eqlocal;
        this.eqvisitante = eqvisitante;
        this.hora = hora;
        this.resultado = resultado;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCompeticion() {
        return competicion;
    }

    public void setCompeticion(String competicion) {
        this.competicion = competicion;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getEqlocal() {
        return eqlocal;
    }

    public void setEqlocal(String eqlocal) {
        this.eqlocal = eqlocal;
    }

    public String getEqvisitante() {
        return eqvisitante;
    }

    public void setEqvisitante(String eqvisitante) {
        this.eqvisitante = eqvisitante;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getResultado() {
        return resultado;
    }

    public void setResultado(String resultado) {
        this.resultado = resultado;
    }
    @Override
    public String toString(){
        return competicion + " - " + fecha + " - " + eqlocal + " - " + eqvisitante + " - " + hora + " - " + resultado;
    }
}
