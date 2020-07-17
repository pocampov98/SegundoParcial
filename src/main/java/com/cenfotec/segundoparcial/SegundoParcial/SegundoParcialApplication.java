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
			repo.save(new Actor("Leonardo DiCaprio","Hombre", new SimpleDateFormat("yyyy-MM-dd").parse("1974-11-11"),175,"Flaco","Verde","Cafe"));
			repo.save(new Actor("Ellen Page","Mujer", new SimpleDateFormat("yyyy-MM-dd").parse("1987-11-11"),175,"Flaco","Verde","Cafe"));
			repo.save(new Actor("Joseph Gordon-Levitt","Hombre", new SimpleDateFormat("yyyy-MM-dd").parse("1998-11-11"),175,"Flaco","Verde","Cafe"));
			repo.save(new Actor("Robert De Niro","Hombre", new SimpleDateFormat("yyyy-MM-dd").parse("1943-11-11"),175,"Flaco","Verde","Cafe"));
			repo.save(new Actor("Daniel Donatto","Hombre", new SimpleDateFormat("yyyy-MM-dd").parse("2007-11-11"),175,"Flaco","Verde","Cafe"));
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
