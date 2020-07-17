package com.cenfotec.segundoparcial.SegundoParcial.repository;

import com.cenfotec.segundoparcial.SegundoParcial.domain.Guion;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;

public interface GuionRepository extends JpaRepository<Guion, Long> {
    ArrayList<Guion> findGuionsByListoProduccionIsTrue();
}
