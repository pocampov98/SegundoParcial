package com.cenfotec.segundoparcial.SegundoParcial.service;

import com.cenfotec.segundoparcial.SegundoParcial.domain.Guion;

import java.util.ArrayList;
import java.util.Optional;

public interface GuionService {

    void createGuion(Guion newGuion);

    void updateEstadoGuion(Long id);

    void updateActoresGuion(Long id, Long idActor, Long idActriz);

    Optional<Guion> readGuion(Long id);

    ArrayList<Guion> readGuiones();

    ArrayList<Guion> readGuionesByNameAndGenre(String nombre, String genero);

    ArrayList<Guion> readGuionesEnProduccion();

}
