package com.hospedaje.web.socio.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hospedaje.web.socio.dto.request.SocioRequest;
import com.hospedaje.web.socio.dto.response.SocioResponse;
import com.hospedaje.web.socio.entity.Socio;
import com.hospedaje.web.socio.service.SocioService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@Validated
@RequestMapping("/socio")
public class SocioController {

	@Autowired
	SocioService socioService;
	
	@GetMapping("/listar")
	public Flux<SocioResponse> listarSocios(@RequestHeader HttpHeaders headers){
		return socioService.listarSocios(headers);
	}
	
	@GetMapping("/{idSocio}")
	public Mono<SocioResponse> obtenerSocio(@PathVariable("idSocio")Integer idSocio){
		return socioService.obtenerSocio(idSocio);
	}
	
	@PostMapping("/agregar")
	public Mono<SocioResponse> agregarSocio(@RequestBody SocioRequest socioRequest,@RequestHeader HttpHeaders headers){
		return socioService.agregarSocio(socioRequest,headers);
	}
	
	@PutMapping("/{idSocio}")
	public Mono<SocioResponse> actualizarSocio(@RequestBody SocioRequest socioRequest,@RequestHeader HttpHeaders headers){
		return socioService.agregarSocio(socioRequest, headers);
	}
	
	
}
