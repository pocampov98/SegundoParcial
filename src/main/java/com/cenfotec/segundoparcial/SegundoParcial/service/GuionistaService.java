package com.cenfotec.segundoparcial.SegundoParcial.service;

import com.cenfotec.segundoparcial.SegundoParcial.domain.Guionista;

import java.util.ArrayList;
import java.util.Optional;

public interface GuionistaService {

    void createGuionista(Guionista newGuionista);

    Optional<Guionista> readGuionista(Long id);

    ArrayList<Guionista> readGuionistas();

}
