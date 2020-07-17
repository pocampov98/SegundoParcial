package com.cenfotec.segundoparcial.SegundoParcial.web;

import com.cenfotec.segundoparcial.SegundoParcial.domain.Actor;
import com.cenfotec.segundoparcial.SegundoParcial.service.ActorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ActorController {

    @Autowired
    private ActorService actorService;

    @PostMapping("/actores")
    public String createActor(@ModelAttribute Actor newActor, Model model){
        actorService.createActor(newActor);
        model.addAttribute("actores", actorService.readActores());
        return "listaActores";
    }

    @RequestMapping("/formularioActor")
    public String showFormActor(Model model){
        model.addAttribute("actor", new Actor());
        model.addAttribute("actores", actorService.readActores());
        return "formularioActor";
    }

    @RequestMapping("/listaActores")
    public String showListaActores(Model model){
        model.addAttribute("actores", actorService.readActores());
        return "listaActores";
    }

    @RequestMapping("/filtrarListaActores")
    public String showListaActoresPorNombreYEdad(
            @RequestParam(value = "nombre", required = false) String nombre,
            @RequestParam(value = "edad", required = false) int edad,
            Model model
    ){
        model.addAttribute("actores", actorService.readActoresByNameAndAge(nombre, edad));
        return "listaActores";
    }
}
