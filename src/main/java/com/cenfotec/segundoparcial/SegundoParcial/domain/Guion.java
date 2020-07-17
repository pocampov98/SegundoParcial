package com.cenfotec.segundoparcial.SegundoParcial.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Guion {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Long idGuionista;
    private String nombreGuionista;
    private String nombre;
    private String genero;
    private String ideaCentral;
    private boolean listoProduccion;
    private Long idActorPrincipal;
    private String nombreActorPrincipal;
    private Long idActrizPrincipal;
    private String nombreActrizPrincipal;

    public Guion() {
    }

    public Guion(
            Long idGuionista,
            String nombre,
            String genero,
            String ideaCentral,
            boolean listoProduccion,
            Long idActorPrincipal,
            Long idActrizPrincipal
    ) {
        this.idGuionista = idGuionista;
        this.nombre = nombre;
        this.genero = genero;
        this.ideaCentral = ideaCentral;
        this.listoProduccion = listoProduccion;
        this.idActorPrincipal = idActorPrincipal;
        this.idActrizPrincipal = idActrizPrincipal;
        this.nombreGuionista = "";
        this.nombreActorPrincipal = "";
        this.nombreActrizPrincipal = "";
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdGuionista() {
        return idGuionista;
    }

    public void setIdGuionista(Long idGuionista) {
        this.idGuionista = idGuionista;
    }

    public String getNombreGuionista() {
        return nombreGuionista;
    }

    public void setNombreGuionista(String nombreGuionista) {
        this.nombreGuionista = nombreGuionista;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getIdeaCentral() {
        return ideaCentral;
    }

    public void setIdeaCentral(String ideaCentral) {
        this.ideaCentral = ideaCentral;
    }

    public boolean isListoProduccion() {
        return listoProduccion;
    }

    public void setListoProduccion(boolean listoProduccion) {
        this.listoProduccion = listoProduccion;
    }

    public Long getIdActorPrincipal() {
        return idActorPrincipal;
    }

    public void setIdActorPrincipal(Long idActorPrincipal) {
        this.idActorPrincipal = idActorPrincipal;
    }

    public Long getIdActrizPrincipal() {
        return idActrizPrincipal;
    }

    public void setIdActrizPrincipal(Long idActrizPrincipal) {
        this.idActrizPrincipal = idActrizPrincipal;
    }

    public String getNombreActorPrincipal() {
        return nombreActorPrincipal;
    }

    public void setNombreActorPrincipal(String nombreActorPrincipal) {
        this.nombreActorPrincipal = nombreActorPrincipal;
    }

    public String getNombreActrizPrincipal() {
        return nombreActrizPrincipal;
    }

    public void setNombreActrizPrincipal(String nombreActrizPrincipal) {
        this.nombreActrizPrincipal = nombreActrizPrincipal;
    }
}
