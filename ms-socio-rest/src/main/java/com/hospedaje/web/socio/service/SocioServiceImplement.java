package com.hospedaje.web.socio.service;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.hospedaje.web.socio.config.ApplicationProperties;
import com.hospedaje.web.socio.dto.request.SocioRequest;
import com.hospedaje.web.socio.dto.response.SocioResponse;
import com.hospedaje.web.socio.entity.Socio;
import com.hospedaje.web.socio.repository.SocioRepository;
import com.hospedaje.web.socio.util.Utilitario;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class SocioServiceImplement implements SocioService{

	private static final Logger LOG = LoggerFactory.getLogger(SocioServiceImplement.class);
	
	Gson gson = new Gson();
	
	@Autowired
	ApplicationProperties properties;
	
	@Autowired
	SocioRepository socioRepository;

	
	@Override
	public Flux<SocioResponse> listarSocios(HttpHeaders headers) {
		
		return socioRepository.findAll()
				.map(this::socioResponseDto);
	}

	@Override
	public Mono<SocioResponse> obtenerSocio(Integer idSocio) {
		return socioRepository.findById(idSocio)
				.map(this::socioResponseDto);
	}

	@Override
	public Mono<SocioResponse> agregarSocio(SocioRequest socioRequest,HttpHeaders headers) {
		return socioRepository.save(getSocioEntity(socioRequest))
				.map(this::socioResponseDto);
	}
	
	private SocioResponse socioResponseDto(Socio socio) {
		return SocioResponse.builder()
				.idSocio(socio.getIdSocio())
				.nombres(socio.getNombres())
				.apellidos(socio.getApellidos())
				.dni(socio.getDni())
				.telefono(socio.getTelefono())
				.creationDate(Utilitario.convertirFechaddMMYYYY(socio.getCreationDate()))
				.enabled(socio.isEnabled())
				.build();
	}
	
	private Socio getSocioEntity(SocioRequest socioRequest) {
		return Socio.builder()
				.idSocio(socioRequest.getIdSocio())
				.nombres(socioRequest.getNombres())
				.apellidos(socioRequest.getApellidos())
				.dni(socioRequest.getDni())
				.telefono(socioRequest.getTelefono())
				.creationDate(new Date())
				.enabled(true).build();
	}
	
}
;