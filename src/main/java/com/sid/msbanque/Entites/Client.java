package com.sid.msbanque.Entites;

import java.util.Collection;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
@XmlRootElement
//annottaions de JaxB sur les attibuts et pas sur les getters
@XmlAccessorType(XmlAccessType.FIELD)
@Entity
@Data @AllArgsConstructor @NoArgsConstructor @ToString
public class Client {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nom;
	//lazy pour ne pas charger les comptes
	@OneToMany(mappedBy = "client",fetch =  FetchType.LAZY)
	@XmlTransient @JsonIgnore
private Collection<Compte>comptes;

}
