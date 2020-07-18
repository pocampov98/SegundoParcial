package com.cenfotec.segundoparcial.SegundoParcial;

import com.cenfotec.segundoparcial.SegundoParcial.domain.Actor;
import com.cenfotec.segundoparcial.SegundoParcial.domain.Guionista;
import com.cenfotec.segundoparcial.SegundoParcial.repository.ActorRepository;
import com.cenfotec.segundoparcial.SegundoParcial.repository.GuionistaRepository;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.text.SimpleDateFormat;

@SpringBootApplication
public class SegundoParcialApplication {

	@Bean
	InitializingBean saveDataActores(ActorRepository repo){
		return () -> {
			repo.save(new Actor("Leonardo Rodriguez","Hombre", new SimpleDateFormat("yyyy-MM-dd").parse("1974-11-11"),175,"Regular","Verde","Cafe"));
			repo.save(new Actor("Ellen Morales","Mujer", new SimpleDateFormat("yyyy-MM-dd").parse("1987-10-11"),168,"Flaco","Azul","Rubio"));
			repo.save(new Actor("Marta Campos","Mujer", new SimpleDateFormat("yyyy-MM-dd").parse("1987-10-11"),168,"Flaco","Azul","Rubio"));
			repo.save(new Actor("Joseph Massey","Hombre", new SimpleDateFormat("yyyy-MM-dd").parse("1998-12-18"),180,"Flaco","Cafe","Cafe"));
			repo.save(new Actor("Robert Solano","Hombre", new SimpleDateFormat("yyyy-MM-dd").parse("1943-11-11"),170,"Grueso","Verde","Cafe"));
			repo.save(new Actor("Daniel Cordero","Hombre", new SimpleDateFormat("yyyy-MM-dd").parse("2007-10-15"),162,"Flaco","Azul","Cafe"));
		};
	}

	@Bean
	InitializingBean saveDataGuionistas(GuionistaRepository repo){
		return () -> {
			repo.save(new Guionista("Leonardo Campos","San Carlos","leo@mail.com", new SimpleDateFormat("yyyy-MM-dd").parse("1974-11-11")));
			repo.save(new Guionista("Michael Barrantes","San Pedro","michael@mail.com", new SimpleDateFormat("yyyy-MM-dd").parse("1985-11-11")));
			repo.save(new Guionista("Eric Sanchez","Desamparados","eric@mail.com", new SimpleDateFormat("yyyy-MM-dd").parse("1970-11-11")));
			repo.save(new Guionista("Maria Fallas","San Rafael","maria@mail.com", new SimpleDateFormat("yyyy-MM-dd").parse("1992-11-11")));
		};
	}

	public static void main(String[] args) {
		SpringApplication.run(SegundoParcialApplication.class, args);
	}

}
