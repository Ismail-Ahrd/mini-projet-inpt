package com.example.miniprojetasedsinpt;

import com.example.miniprojetasedsinpt.entities.Personne;
import com.example.miniprojetasedsinpt.entities.utils.Cadre;
import com.example.miniprojetasedsinpt.entities.utils.TypePersonne;
import com.example.miniprojetasedsinpt.services.PersonneService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.stream.Stream;

@SpringBootApplication
public class MiniProjetAsedsInptApplication {

	public static void main(String[] args) {
		SpringApplication.run(MiniProjetAsedsInptApplication.class, args);
		
	}

	@Bean
	public CommandLineRunner commandLineRunner(
			PersonneService personneService
	) {
		return args -> {
			Stream.of("Hassan","Ahmed", "Najat")
					.forEach(name -> {
						Personne p = new Personne();
						p.setPrenom(name);
						p.setNom(name);
						p.setEmail(name+"@gmail.com");
						p.setMdp("123456");
						p.setType(TypePersonne.AGENT_CONTROLE);
						personneService.savePersonne(p);
					});

		}
		;
	}

}
