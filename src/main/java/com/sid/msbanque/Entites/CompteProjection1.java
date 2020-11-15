package com.sid.msbanque.Entites;

import org.springframework.data.rest.core.config.Projection;
//donner seuelemnt le solde 
@Projection(name="solde",types=Compte.class)
public interface CompteProjection1 {
	
	public double getSolde();
	
	

}
