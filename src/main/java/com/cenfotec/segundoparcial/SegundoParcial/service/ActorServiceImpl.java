package com.cenfotec.segundoparcial.SegundoParcial.service;

import com.cenfotec.segundoparcial.SegundoParcial.domain.Actor;
import com.cenfotec.segundoparcial.SegundoParcial.repository.ActorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;

@Service
public class ActorServiceImpl implements ActorService{

    @Autowired
    ActorRepository actorRepository;


    @Override
    public void createActor(Actor newActor) {
        actorRepository.save(newActor);
    }

    @Override
    public ArrayList<Actor> readActores() {
        return (ArrayList<Actor>) actorRepository.findAll();
    }

    @Override
    public ArrayList<Actor> readActoresByNameAndAge(String nombre, int edad) {
        ArrayList<Actor> actores = (ArrayList<Actor>) actorRepository.findAll();
        ArrayList<Actor> listaFiltrada = new ArrayList<>();
        for(Actor actor: actores){
            if(actor.getNombre().toLowerCase().contains(nombre.toLowerCase()) || nombre.equalsIgnoreCase("")){
                if(checkAgeRange(edad,actor.getFechaNacimiento())){
                    listaFiltrada.add(actor);
                }
            }
        }
        return listaFiltrada;
    }

    @Override
    public ArrayList<Actor> readActoresByGender(String genero) {
        return actorRepository.findActorsByGeneroEquals(genero);
    }

    public boolean checkAgeRange(int rango, Date fechaNacimiento){
        Period diff = Period.between(
                fechaNacimiento.toInstant().atZone(ZoneId.systemDefault()).toLocalDate(),
                LocalDate.now()
        );
        int edad = diff.getYears();
        switch (rango){
            case 0:
                return true;
            case 1:
                if(edad <= 18)
                    return true;
                break;
            case 2:
                if(edad > 18 && edad <= 30)
                    return true;
                break;
            case 3:
                if(edad > 30 && edad <= 40)
                    return true;
                break;
            case 4:
                if(edad > 40 && edad <= 60)
                    return true;
                break;
            case 5:
                if(edad > 60)
                    return true;
                break;
                default:
                    return false;
        }
        return false;
    }
}
