package com.cenfotec.segundoparcial.SegundoParcial.service;

import com.cenfotec.segundoparcial.SegundoParcial.domain.Guion;
import com.cenfotec.segundoparcial.SegundoParcial.repository.GuionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class GuionServiceImpl implements GuionService {

    @Autowired
    GuionRepository guionRepository;

    @Override
    public void createGuion(Guion newGuion) {
        newGuion.setIdActorPrincipal(0L);
        newGuion.setIdActrizPrincipal(0L);
        newGuion.setNombreActorPrincipal("");
        newGuion.setNombreActrizPrincipal("");
        newGuion.setNombreGuionista("");
        guionRepository.save(newGuion);
    }

    @Override
    public void updateEstadoGuion(Long id) {
        Optional<Guion> guion = guionRepository.findById(id);
        guion.get().setListoProduccion(true);
        guionRepository.save(guion.get());
    }

    @Override
    public void updateActoresGuion(Long id, Long idActor, Long idActriz) {
        Optional<Guion> guion = guionRepository.findById(id);
        guion.get().setIdActorPrincipal(idActor);
        guion.get().setIdActrizPrincipal(idActriz);
        guionRepository.save(guion.get());
    }

    @Override
    public Optional<Guion> readGuion(Long id) {
        return guionRepository.findById(id);
    }

    @Override
    public ArrayList<Guion> readGuiones() {
        return (ArrayList<Guion>) guionRepository.findAll();
    }

    @Override
    public ArrayList<Guion> readGuionesByNameAndGenre(String nombre, String genero) {
        ArrayList<Guion> guiones = (ArrayList<Guion>) guionRepository.findAll();
        ArrayList<Guion> listaFiltrada = new ArrayList<>();
        for(Guion guion: guiones){
            if(guion.getNombre().toLowerCase().contains(nombre.toLowerCase()) || nombre.equalsIgnoreCase("")){
                if(guion.getGenero().toLowerCase().contains(genero.toLowerCase()) || genero.equalsIgnoreCase("")){
                    listaFiltrada.add(guion);
                }
            }
        }
        return listaFiltrada;
    }

    @Override
    public ArrayList<Guion> readGuionesEnProduccion() {
        return guionRepository.findGuionsByListoProduccionIsTrue();
    }
}
