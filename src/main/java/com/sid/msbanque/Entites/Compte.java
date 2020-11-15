package com.sid.msbanque.Entites;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
@XmlRootElement
@Entity
//les annotations lombook
@Data @NoArgsConstructor @AllArgsConstructor @ToString
public class Compte {
@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private double solde;
	@Temporal(TemporalType.DATE)
	private Date dateCreation;
	//au niveau de la base de donee atteibut sera numerrique
	//par default c est ordinal
	
	@Enumerated(EnumType.STRING)
	@Column(length =10 )
	private TypeCompte type;
	@ManyToOne
	private Client client;
	
	
	

}
