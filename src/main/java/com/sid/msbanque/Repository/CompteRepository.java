package com.sid.msbanque.Repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.data.rest.webmvc.RepositoryRestController;

import com.sid.msbanque.Entites.Compte;
import com.sid.msbanque.Entites.TypeCompte;
@RepositoryRestController
public interface CompteRepository extends JpaRepository<Compte, Long> {
	//chercher par type de compte
	@RestResource(path="/byType")
	public List<Compte> findByType(@Param("t")TypeCompte type);
     
}
