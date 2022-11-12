package com.hospedaje.web.socio.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hospedaje.web.socio.entity.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client,Integer> {


}
