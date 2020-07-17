package com.cenfotec.segundoparcial.SegundoParcial.web;

import com.cenfotec.segundoparcial.SegundoParcial.domain.Actor;
import com.cenfotec.segundoparcial.SegundoParcial.domain.Guion;
import com.cenfotec.segundoparcial.SegundoParcial.domain.Guionista;
import com.cenfotec.segundoparcial.SegundoParcial.service.ActorService;
import com.cenfotec.segundoparcial.SegundoParcial.service.GuionService;
import com.cenfotec.segundoparcial.SegundoParcial.service.GuionistaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@Controller
public class GuionController {

    @Autowired
    GuionService guionService;

    @Autowired
    GuionistaService guionistaService;

    @Autowired
    ActorService actorService;

    @PostMapping("/guiones")
    public String createGuion(@ModelAttribute Guion newGuion, Model model){
        guionService.createGuion(newGuion);

        ArrayList<Guion> guiones = guionService.readGuiones();
        ArrayList<Guionista> guionistas = guionistaService.readGuionistas();
        asignarNombreGuionistas(guiones,guionistas);

        model.addAttribute("guiones", guiones);
        return "listaGuiones";
    }

    @RequestMapping("/actualizarEstadoProduccion")
    public String actualizarEstadoProduccion(
            @RequestParam(value = "id", required = false) Long id,
            Model model
    ){
        guionService.updateEstadoGuion(id);

        ArrayList<Guion> guiones = guionService.readGuiones();
        ArrayList<Guionista> guionistas = guionistaService.readGuionistas();
        asignarNombreGuionistas(guiones,guionistas);

        model.addAttribute("guiones", guiones);
        return "listaGuiones";
    }

    @RequestMapping("/asignarActores")
    public String asignarActores(
            @RequestParam(value = "idGuion", required = false) Long idGuion,
            @RequestParam(value = "idActor", required = false) Long idActor,
            @RequestParam(value = "idActriz", required = false) Long idActriz,
            Model model
    ){
        guionService.updateActoresGuion(idGuion,idActor,idActriz);

        ArrayList<Guion> guiones = guionService.readGuionesEnProduccion();
        ArrayList<Guionista> guionistas = guionistaService.readGuionistas();
        ArrayList<Actor> actores = actorService.readActores();
        asignarNombreGuionistas(guiones,guionistas);
        asignarNombreActores(guiones,actores);

        model.addAttribute("guiones", guiones);
        return "listaGuionesEnProduccion";
    }

    @RequestMapping("/formularioGuion")
    public String showFormGuion(Model model){
        model.addAttribute("guion", new Guion());
        model.addAttribute("guionistas", guionistaService.readGuionistas());
        return "formularioGuion";
    }

    @RequestMapping("/formularioAsignarActores")
    public String showFormAsignarActores(@RequestParam Long idGuion,Model model){
        model.addAttribute("guion", guionService.readGuion(idGuion));
        model.addAttribute("actores", actorService.readActoresByGender("Hombre"));
        model.addAttribute("actrizes", actorService.readActoresByGender("Mujer"));
        return "formularioAsignarActores";
    }

    @RequestMapping("/listaGuiones")
    public String showListaGuiones(Model model){
        ArrayList<Guion> guiones = guionService.readGuiones();
        ArrayList<Guionista> guionistas = guionistaService.readGuionistas();
        asignarNombreGuionistas(guiones,guionistas);

        model.addAttribute("guiones", guiones);
        return "listaGuiones";
    }

    @RequestMapping("/filtrarListaGuiones")
    public String showListaGuionesPorNombreYGenero(
            @RequestParam(value = "nombre", required = false) String nombre,
            @RequestParam(value = "genero", required = false) String genero,
            Model model
    ){
        ArrayList<Guion> guiones = guionService.readGuionesByNameAndGenre(nombre,genero);
        ArrayList<Guionista> guionistas = guionistaService.readGuionistas();
        asignarNombreGuionistas(guiones,guionistas);

        model.addAttribute("guiones", guiones);
        return "listaGuiones";
    }

    @RequestMapping("/listaGuionesEnProduccion")
    public String showListaGuionesEnProduccion(Model model){
        ArrayList<Guion> guiones = guionService.readGuionesEnProduccion();
        ArrayList<Guionista> guionistas = guionistaService.readGuionistas();
        ArrayList<Actor> actores = actorService.readActores();
        asignarNombreGuionistas(guiones,guionistas);
        asignarNombreActores(guiones,actores);

        model.addAttribute("guiones", guiones);
        return "listaGuionesEnProduccion";
    }

    public void asignarNombreGuionistas(ArrayList<Guion> guiones, ArrayList<Guionista> guionistas){
        for (Guion guion:guiones){
            for(Guionista guionista:guionistas){
                if(guion.getIdGuionista().equals(guionista.getId()))
                    guion.setNombreGuionista(guionista.getNombre());
            }
        }
    }

    public void asignarNombreActores(ArrayList<Guion> guiones, ArrayList<Actor> actores){
        for (Guion guion:guiones){
            for(Actor actor:actores){
                if(!guion.getIdActorPrincipal().equals(0L))
                    if(guion.getIdActorPrincipal().equals(actor.getId()))
                        guion.setNombreActorPrincipal(actor.getNombre());
                if(!guion.getIdActrizPrincipal().equals(0L))
                    if(guion.getIdActrizPrincipal().equals(actor.getId()))
                        guion.setNombreActrizPrincipal(actor.getNombre());
            }
        }
    }


}
