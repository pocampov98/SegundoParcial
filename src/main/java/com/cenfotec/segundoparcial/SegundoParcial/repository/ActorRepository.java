package com.cenfotec.segundoparcial.SegundoParcial.repository;

import com.cenfotec.segundoparcial.SegundoParcial.domain.Actor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;

public interface ActorRepository extends JpaRepository<Actor, Long> {
    ArrayList<Actor> findActorsByGeneroEquals(String genero);
}
