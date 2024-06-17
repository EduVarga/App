package jpaswing.entity;

import jakarta.persistence.*;
import org.springframework.stereotype.Component;

@Entity
@Table(name = "noticias")
public class Noticia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String imagen;
    private String titular;
    private String corta;
    private String larga;
    public Noticia(){

    }

    public Noticia(String imagen, String titular, String corta, String larga) {
        this.imagen = imagen;
        this.titular = titular;
        this.corta = corta;
        this.larga = larga;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public String getTitular() {
        return titular;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    public String getCorta() {
        return corta;
    }

    public void setCorta(String corta) {
        this.corta = corta;
    }

    public String getLarga() {
        return larga;
    }

    public void setLarga(String larga) {
        this.larga = larga;
    }
    public String toString(){
        return imagen + " - " + titular + " - " + corta + " - " + larga;
    }
}
