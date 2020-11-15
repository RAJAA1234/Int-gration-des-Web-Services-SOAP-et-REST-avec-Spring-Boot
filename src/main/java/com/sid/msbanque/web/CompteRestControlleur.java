package com.sid.msbanque.web;

import java.util.List;


import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sid.msbanque.Entites.Compte;
import com.sid.msbanque.Repository.CompteRepository;
//pour considerer path comme un composant spring
//desctiver le cas2

//@RestController
@RequestMapping("/banque")
public class CompteRestControlleur {
	@Autowired
	CompteRepository compteRepository;

	@GetMapping(path = "/comptes",produces = {MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public List<Compte> CompteList(){
     return compteRepository.findAll();
}
	
	
	
	@GetMapping("/comptes/{id}")
	//@PathParam de jaxrs
	
	public Compte getOne(@PathVariable (value = "id")Long id){
     return compteRepository.findById(id).get();
}
	
	@PostMapping(path="/comptes")
	//les donnes se retrouvent dans la requettes
	public Compte save(@RequestBody Compte compte ){
     return compteRepository.save(compte);
}
@PutMapping("/comptes/{id}")
	
	public  Compte update(@RequestBody Compte compte,@PathVariable (value = "id")Long id){
		compte.setId(id);
		
	    return compteRepository.save(compte);
}
	
@DeleteMapping("/comptes/{id}")
	
	public  void Delete(@PathVariable (value = "id")Long id){
	
	    compteRepository.deleteById(id);
}


}
