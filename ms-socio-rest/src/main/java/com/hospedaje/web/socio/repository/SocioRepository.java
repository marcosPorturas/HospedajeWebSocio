package com.hospedaje.web.socio.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import com.hospedaje.web.socio.entity.Socio;

import reactor.core.publisher.Mono;


@Repository
public interface SocioRepository extends ReactiveMongoRepository<Socio,Integer> {
	
	Mono<Socio> findByIdSocio(Integer idSocio);

}
