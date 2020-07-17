package com.cenfotec.segundoparcial.SegundoParcial.service;

import com.cenfotec.segundoparcial.SegundoParcial.domain.Guionista;
import com.cenfotec.segundoparcial.SegundoParcial.repository.GuionistaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class GuionistaServiceImpl implements GuionistaService{

    @Autowired
    GuionistaRepository guionistaRepository;

    @Override
    public void createGuionista(Guionista newGuionista) {
        guionistaRepository.save(newGuionista);
    }

    @Override
    public Optional<Guionista> readGuionista(Long id) {
        return guionistaRepository.findById(id);
    }

    @Override
    public ArrayList<Guionista> readGuionistas() {
        return (ArrayList<Guionista>) guionistaRepository.findAll();
    }
}
