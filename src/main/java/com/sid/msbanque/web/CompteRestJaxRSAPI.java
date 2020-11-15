package com.sid.msbanque.web;
import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sid.msbanque.Entites.Compte;
import com.sid.msbanque.Repository.CompteRepository;
//pour considerer path comme un composant spring
@Component
@Path("/banque")
public class CompteRestJaxRSAPI {
	@Autowired
	CompteRepository compteRepository;
	
	@Path("/comptes")
	//LES annotatios de jaxrs
	@GET
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	
	public List<Compte> CompteList(){
     return compteRepository.findAll();
}
	@Path("/comptes/{id}")
	//LES annotatios de jaxrs
	@GET
	@Produces({MediaType.APPLICATION_JSON})
	//@PathParam de jaxrs
	
	public Compte getOne(@PathParam (value = "id")Long id){
     return compteRepository.findById(id).get();
}
	
	@Path("/comptes")
	//LES annotatios de jaxrs
	@POST
	@Produces({MediaType.APPLICATION_JSON})
	
	public Compte save(Compte compte ){
     return compteRepository.save(compte);
}
	@Path("/comptes/{id}")
	//LES annotatios de jaxrs
	@PUT
	@Produces({MediaType.APPLICATION_JSON})
	
	public  Compte update(Compte compte,@PathParam (value = "id")Long id){
		compte.setId(id);
		
	    return compteRepository.save(compte);
}
	

	@Path("/comptes/{id}")
	//LES annotatios de jaxrs
	@DELETE
	@Produces({MediaType.APPLICATION_JSON})
	
	public  void Delete(@PathParam (value = "id")Long id){
	
	    compteRepository.deleteById(id);
}









}