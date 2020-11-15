package com.sid.msbanque.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.webmvc.RepositoryRestController;

import com.sid.msbanque.Entites.Client;
@RepositoryRestController
public interface ClientRepository extends JpaRepository<Client,Long> {

}
