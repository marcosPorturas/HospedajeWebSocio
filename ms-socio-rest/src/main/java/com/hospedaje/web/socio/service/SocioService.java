package com.hospedaje.web.socio.service;

import org.springframework.http.HttpHeaders;

import com.hospedaje.web.socio.dto.request.SocioRequest;
import com.hospedaje.web.socio.dto.response.SocioResponse;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface SocioService {

	public Flux<SocioResponse> listarSocios(HttpHeaders headers);
	public Mono<SocioResponse> obtenerSocio(Integer idSocio);
	public Mono<SocioResponse> agregarSocio(SocioRequest socioRequest,HttpHeaders headers);
	
}
