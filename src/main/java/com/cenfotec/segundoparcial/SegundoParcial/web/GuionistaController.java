package com.cenfotec.segundoparcial.SegundoParcial.web;

import com.cenfotec.segundoparcial.SegundoParcial.domain.Guionista;
import com.cenfotec.segundoparcial.SegundoParcial.service.GuionistaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class GuionistaController {

    @Autowired
    GuionistaService guionistaService;

    @PostMapping("/guionistas")
    public String createGuionista(@ModelAttribute Guionista newGuionista, Model model){
        guionistaService.createGuionista(newGuionista);
        model.addAttribute("guionistas", guionistaService.readGuionistas());
        return "listaGuionistas";
    }

    @RequestMapping("/formularioGuionista")
    public String showFormGuionista(Model model){
        model.addAttribute("guionista", new Guionista());
        model.addAttribute("guionistas", guionistaService.readGuionistas());
        return "formularioGuionista";
    }

    @RequestMapping("/listaGuionistas")
    public String showListaGuionistas(Model model){
        model.addAttribute("guionistas", guionistaService.readGuionistas());
        return "listaGuionistas";
    }

    @RequestMapping("/index")
    public String showIndex(){
        return "index";
    }

}
