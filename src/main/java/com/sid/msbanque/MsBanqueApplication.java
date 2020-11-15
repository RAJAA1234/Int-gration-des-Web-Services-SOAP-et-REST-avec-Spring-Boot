package com.sid.msbanque;

import java.util.Date;


import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

import com.sid.msbanque.Entites.Client;
import com.sid.msbanque.Entites.Compte;
import com.sid.msbanque.Entites.TypeCompte;
import com.sid.msbanque.Repository.ClientRepository;
import com.sid.msbanque.Repository.CompteRepository;




@SpringBootApplication
public class MsBanqueApplication {
	 
	

	public static void main(String[] args) {
		SpringApplication.run(MsBanqueApplication.class, args);
	}
	//excuter la methode au demarrage utiliser @Bean
	@Bean
	CommandLineRunner start(CompteRepository compteRepository ,RepositoryRestConfiguration restConfiguration,ClientRepository clientRepository){
		
		return args ->  {
			//pour exposer le id des comptes
			restConfiguration.exposeIdsFor(Compte.class);
		Client C1=	clientRepository.save(new Client(null,"Hasaan",null));
			Client C2=clientRepository.save(new Client(null,"mohamed",null));
	
			compteRepository.save(new Compte(null,Math.random()*9000,new Date(),TypeCompte.EPANGNE,C1 ));
			compteRepository.save(new Compte(null,Math.random()*9000,new Date(),TypeCompte.COURANT,C1 ));
			compteRepository.save(new Compte(null,Math.random()*9000,new Date(),TypeCompte.EPANGNE,C2 ));
			compteRepository.findAll().forEach(c->{
				System.out.println(c.getSolde());
			
			});
			
			
		};
		
		
		
		
	}

}
