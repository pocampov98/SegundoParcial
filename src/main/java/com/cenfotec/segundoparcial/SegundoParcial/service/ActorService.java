package com.cenfotec.segundoparcial.SegundoParcial.service;

import com.cenfotec.segundoparcial.SegundoParcial.domain.Actor;

import java.util.ArrayList;

public interface ActorService {

    void createActor(Actor newActor);

    ArrayList<Actor> readActores();

    ArrayList<Actor> readActoresByNameAndAge(String nombre, int edad);

    ArrayList<Actor> readActoresByGender(String genero);
}
